package com.enbiz.api.bo.app.service.system;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.login.CurrentUser;
import com.enbiz.api.bo.app.dto.request.dashboard.DashboardNoticeRequest;
import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.dto.request.system.SystemNoticeCudRequest;
import com.enbiz.api.bo.app.dto.request.system.SystemNoticeFileCudRequest;
import com.enbiz.api.bo.app.dto.request.system.SystemNoticeListRequest;
import com.enbiz.api.bo.app.dto.response.dashboard.DashboardNoticeResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeAttachFileResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeInfoResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeListResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeTargetInfoResponse;
import com.enbiz.api.bo.app.entity.StBbAtchFile;
import com.enbiz.api.bo.app.entity.StBbTgtInfo;
import com.enbiz.api.bo.app.entity.StSysBbInfo;
import com.enbiz.api.bo.app.entity.StUserBase;
import com.enbiz.api.bo.app.repository.main.system.StBbAtchFileMapper;
import com.enbiz.api.bo.app.repository.main.system.StBbAtchFileTrxMapper;
import com.enbiz.api.bo.app.repository.main.system.StBbTgtInfoMapper;
import com.enbiz.api.bo.app.repository.main.system.StBbTgtInfoTrxMapper;
import com.enbiz.api.bo.app.repository.main.system.StSysBbInfoMapper;
import com.enbiz.api.bo.app.repository.main.system.StSysBbInfoTrxMapper;
import com.enbiz.common.base.Validator;
import com.enbiz.common.base.exception.MessageResolver;
import com.enbiz.common.base.exception.ValidationException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Lazy
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SystemNoticeMgmtServiceImpl implements SystemNoticeMgmtService {
	private final StSysBbInfoTrxMapper stSysBbInfoTrxMapper;
	private final StSysBbInfoMapper stSysBbInfoMapper;
	private final StBbAtchFileTrxMapper stBbAtchFileTrxMapper;
	private final StBbAtchFileMapper stBbAtchFileMapper;
	private final StBbTgtInfoTrxMapper stBbTgtInfoTrxMapper;
	private final StBbTgtInfoMapper stBbTgtInfoMapper;

	/**
	 * 시스템 공지 저장처리
	 * 
	 * @param req
	 * @param cudList
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void registSystemNoticeInfo(SystemNoticeCudRequest req, RealGridCUDRequest<StUserBase> cudList)
			throws Exception {

		sysNtcSaveValidator(req, cudList);

		StSysBbInfo stSysBbInfo = mappedStSysBbInfo(req);

		long bbcNo = stSysBbInfoMapper.getBbcNo();
		stSysBbInfo.setBbcNo(String.valueOf(bbcNo));

		if (stSysBbInfo.getBbYn().equals("Y")) {
			stSysBbInfo.setBbStrDtm(stSysBbInfo.getBbStrDtm() + ":00");
			stSysBbInfo.setBbEndDtm(stSysBbInfo.getBbEndDtm() + ":59");
		} else {
			stSysBbInfo.setBbStrDtm(null);
			stSysBbInfo.setBbEndDtm(null);
		}

		if (stSysBbInfo.getPopYn().equals("Y")) {
			stSysBbInfo.setPopBbStrDtm(stSysBbInfo.getPopBbStrDtm() + ":00");
			stSysBbInfo.setPopBbEndDtm(stSysBbInfo.getPopBbEndDtm() + ":59");
		} else {
			stSysBbInfo.setPopBbStrDtm(null);
			stSysBbInfo.setPopBbEndDtm(null);
		}

		stSysBbInfoTrxMapper.insertStSysBbInfo(stSysBbInfo);

		moveFileAndInsert(req.getTmpFileList(), null, stSysBbInfo.getBbcNo());

		if ("02".equals(stSysBbInfo.getNtcGbCd())) {
			List<StUserBase> ntcInsertTgtList = cudList.getCreate();

			for (StUserBase userInfo : ntcInsertTgtList) {
				StBbTgtInfo stBbTgtInfo = new StBbTgtInfo();
				BeanUtils.copyProperties(userInfo, stBbTgtInfo);

				stBbTgtInfo.setBbcNo(String.valueOf(bbcNo));
				stBbTgtInfo.setEntrNo(userInfo.getUserId());

				stBbTgtInfoTrxMapper.insertStBbTgtInfo(stBbTgtInfo);
			}
		}
	}

	/**
	 * 시스템 공지 수정
	 * 
	 * @param req
	 * @param cudList
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void modifySystemNoticeInfo(SystemNoticeCudRequest req, RealGridCUDRequest<StUserBase> cudList)
			throws Exception {

		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		log.debug("id {}", currentUser.getLoginId());

		sysNtcSaveValidator(req, cudList);

		StSysBbInfo stSysBbInfo = mappedStSysBbInfo(req);

		if (stSysBbInfo.getBbYn().equals("Y")) {
			stSysBbInfo.setBbStrDtm(stSysBbInfo.getBbStrDtm() + ":00");
			stSysBbInfo.setBbEndDtm(stSysBbInfo.getBbEndDtm() + ":59");
		} else {
			stSysBbInfo.setBbStrDtm(null);
			stSysBbInfo.setBbEndDtm(null);
		}

		if (stSysBbInfo.getPopYn().equals("Y")) {
			stSysBbInfo.setPopBbStrDtm(stSysBbInfo.getPopBbStrDtm() + ":00");
			stSysBbInfo.setPopBbEndDtm(stSysBbInfo.getPopBbEndDtm() + ":59");
		} else {
			stSysBbInfo.setPopBbStrDtm(null);
			stSysBbInfo.setPopBbEndDtm(null);
		}

		stSysBbInfoTrxMapper.updateStSysBbInfo(stSysBbInfo);

		moveFileAndInsert(req.getTmpFileList(), req.getDelFileList(), stSysBbInfo.getBbcNo());

		if ("02".equals(stSysBbInfo.getNtcGbCd())) {
			List<StUserBase> createList = cudList.getCreate();
			for (StUserBase userInfo : createList) {
				StBbTgtInfo stBbTgtInfo = new StBbTgtInfo();
				BeanUtils.copyProperties(userInfo, stBbTgtInfo);

				stBbTgtInfo.setBbcNo(req.getBbcNo());
				stBbTgtInfo.setEntrNo(userInfo.getUserId());

				stBbTgtInfoTrxMapper.insertStBbTgtInfo(stBbTgtInfo);
			}
		}

		List<StUserBase> deleteList = cudList.getDelete();
		for (StUserBase userInfo : deleteList) {
			StBbTgtInfo stBbTgtInfo = new StBbTgtInfo();
			BeanUtils.copyProperties(userInfo, stBbTgtInfo);

			stBbTgtInfo.setBbcNo(req.getBbcNo());
			stBbTgtInfo.setEntrNo(userInfo.getUserId());

			stBbTgtInfoTrxMapper.deleteStBbTgtInfo(stBbTgtInfo);
		}
	}

	/**
	 * 시스템 공지 entity mapping
	 * 
	 * @param req
	 * @return
	 */
	private StSysBbInfo mappedStSysBbInfo(SystemNoticeCudRequest req) {
		StSysBbInfo stSysBbInfo = new StSysBbInfo();
		BeanUtils.copyProperties(req, stSysBbInfo);

		return stSysBbInfo;
	}

	/**
	 * 파일 이동 및 파일정보 저장
	 * 
	 * @param uploadFiles
	 * @param deleteFiles
	 * @param bbcNo
	 * @throws Exception
	 */
	private void moveFileAndInsert(List<SystemNoticeFileCudRequest> uploadFiles,
			List<SystemNoticeFileCudRequest> deleteFiles, String bbcNo) throws Exception {
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (Objects.nonNull(uploadFiles) && !uploadFiles.isEmpty()) {
			int maxFileSeq = stBbAtchFileMapper.getMaxFileSeq(bbcNo);
			int i = 1;
			for (SystemNoticeFileCudRequest file : uploadFiles) {
				StBbAtchFile stBbAtchFile = new StBbAtchFile();
				BeanUtils.copyProperties(file, stBbAtchFile);

				stBbAtchFile.setBbcNo(bbcNo);
				stBbAtchFile.setFileSeq(maxFileSeq + i);
				stBbAtchFile.setSysRegId(currentUser.getLoginId());
				stBbAtchFile.setSysModId(currentUser.getLoginId());
				stBbAtchFileTrxMapper.insertStBbAtchFile(stBbAtchFile);

				i++;
			}
		}

		if (Objects.nonNull(deleteFiles) && !deleteFiles.isEmpty()) {
			for (SystemNoticeFileCudRequest delFile : deleteFiles) {
				StBbAtchFile stBbAtchFile = new StBbAtchFile();
				BeanUtils.copyProperties(delFile, stBbAtchFile);

				stBbAtchFileTrxMapper.deleteStBbAtchFile(stBbAtchFile);
			}
		}
	}

	/**
	 * 시스템 공지 validator
	 * 
	 * @param req
	 * @param cudList
	 * @throws Exception
	 */
	private void sysNtcSaveValidator(SystemNoticeCudRequest req, RealGridCUDRequest<StUserBase> cudList)
			throws Exception {

		Validator.throwIfEmpty(req.getTitle(),
				MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "Title" }));

		Validator.throwIfEmpty(req.getSysGbCd(),
				MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "SysGbCd" }));

		Validator.throwIfLongerThan(req.getTitle(), 100,
				MessageResolver.getMessage("systemNoticeMgmt.message.sys.ntc.mgmt.title.limit.length"));

		Validator.throwIfEmpty(req.getBbcCont(),
				MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "BbcCont" }));

		Validator.throwIfEmpty(req.getBbcCont().replaceAll("<p>&nbsp;</p>", ""),
				MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "BbcCont" }));

		if ("Y".equals(req.getBbYn())) {
			Validator.throwIfEmpty(req.getBbStrDtm(),
					MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "BbStrDtm" }));
			Validator.throwIfEmpty(req.getBbEndDtm(),
					MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "BbEndDtm" }));
		}

		if ("02".equals(req.getNtcGbCd())) {
			if (StringUtils.isEmpty(req.getBbcNo())) {
				if (Objects.isNull(cudList.getCreate()) || cudList.getCreate().isEmpty()) {
					throw new ValidationException(MessageResolver.getMessage("adminCommon.message.parameter.empty",
							new String[] { "createList" }));
				}
			} else {
				List<SystemNoticeTargetInfoResponse> tgtList = stBbTgtInfoMapper
						.getStBbTgtInfoListAddStUserBase(req.getBbcNo());

				if (Objects.isNull(tgtList) || tgtList.isEmpty()) {
					if (Objects.isNull(cudList.getCreate()) || cudList.getCreate().isEmpty()) {
						throw new ValidationException(MessageResolver.getMessage("adminCommon.message.parameter.empty",
								new String[] { "createList" }));
					}
				} else {
					if (tgtList.size() == cudList.getDelete().size()) {
						throw new ValidationException(MessageResolver.getMessage("adminCommon.message.parameter.empty",
								new String[] { "createList" }));
					}
				}
			}
		}
	}

	/**
	 * 시스템 공지 정보 조회
	 * 
	 * @param bbcNo
	 * @return
	 * @throws Exception
	 */
	@Override
	public SystemNoticeInfoResponse getSystemNoticeInfo(String bbcNo) throws Exception {
		Validator.throwIfEmpty(bbcNo,
				MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "bbcNo" }));

		StSysBbInfo stSysBbInfo = stSysBbInfoMapper.getStSysBbInfo(bbcNo);

		Validator.throwIfNull(stSysBbInfo,
				MessageResolver.getMessage("systemNoticeMgmt.message.sys.ntc.mgmt.notexist.bbcNo"));

		return new SystemNoticeInfoResponse(stSysBbInfo, stBbAtchFileMapper.getStBbAtchFileList(bbcNo));
	}

	/**
	 * 시스템 대상 정보 조회
	 * 
	 * @param bbcNo
	 * @return
	 */
	@Override
	public List<SystemNoticeTargetInfoResponse> getSystemNoticeTargetInfoList(String bbcNo) {
		return stBbTgtInfoMapper.getStBbTgtInfoListAddStUserBase(bbcNo);
	}

	/**
	 * 시스템공지관리 목록 조회
	 * 
	 * @param SystemNoticeManagementListRequest
	 * @return 시스템공지관리 목록
	 * @throws
	 */
	@Override
	public List<SystemNoticeListResponse> getSystemNoticeList(SystemNoticeListRequest systemNoticeListRequest) {
		return stSysBbInfoMapper.getStSysBbInfoList(systemNoticeListRequest);
	}

	/**
	 * 시스템공지관리 목록 수 조회
	 * 
	 * @param SystemNoticeManagementListRequest
	 * @return 시스템공지관리 목록 수
	 * @throws
	 */
	@Override
	public int getSystemNoticeListCount(SystemNoticeListRequest systemNoticeListRequest) {
		return stSysBbInfoMapper.getBbInfoListTotalCnt(systemNoticeListRequest);
	}

	@Override
	public List<DashboardNoticeResponse> getSystemNoticeInfoListByToday(DashboardNoticeRequest dashboardNoticeRequest) {
		return stSysBbInfoMapper.getSysNtcInfoListByToday(dashboardNoticeRequest);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public DashboardNoticeResponse getSystemNoticeInfoListByTodayDetail(DashboardNoticeRequest dashboardNoticeRequest) {
		DashboardNoticeResponse notice = stSysBbInfoMapper.getSysNtcInfoListByTodayDetail(dashboardNoticeRequest);
		Validator.throwIfNull(notice, MessageResolver.getMessage("adminCommon.message.invaild.access"));
		stSysBbInfoTrxMapper.updateStSysBbInfoQryCnt(dashboardNoticeRequest.getBbcNo());
		return notice;
	}

	@Override
	public List<SystemNoticeAttachFileResponse> getAttachFileList(String bbcNo) {
		return stBbAtchFileMapper.getStBbAtchFileList(bbcNo);
	}
}
