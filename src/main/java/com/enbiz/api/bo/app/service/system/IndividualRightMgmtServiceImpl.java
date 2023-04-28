package com.enbiz.api.bo.app.service.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.login.CurrentUser;
import com.enbiz.api.bo.app.dto.request.system.IndividualRtInfoRequest;
import com.enbiz.api.bo.app.dto.request.system.RtTargetBaseRequest;
import com.enbiz.api.bo.app.dto.response.system.IndividualRtInfoResponse;
import com.enbiz.api.bo.app.dto.response.system.RtTargetBaseResponse;
import com.enbiz.api.bo.app.entity.StIndivRtBaseInfo;
import com.enbiz.api.bo.app.entity.StRtInfo;
import com.enbiz.api.bo.app.repository.main.system.StIndivRtBaseInfoMapper;
import com.enbiz.api.bo.app.repository.main.system.StRtTgtBaseMapper;
import com.enbiz.api.bo.app.repository.main.system.StIndivRtBaseInfoTrxMapper;
import com.enbiz.api.bo.app.repository.main.system.StRtInfoTrxMapper;
import com.enbiz.common.base.Validator;
import com.enbiz.common.base.exception.MessageResolver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 개별 권한 관리 서비스 IMPL
 */
@Service
@Lazy
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class IndividualRightMgmtServiceImpl implements IndividualRightMgmtService {
	private final StRtTgtBaseMapper stRtTgtBaseMapper;
	private final StIndivRtBaseInfoMapper stIndivRtBaseInfoMapper;
	private final StIndivRtBaseInfoTrxMapper stIndivRtBaseInfoTrxMapper;
	private final StRtInfoTrxMapper stRtInfoTrxMapper;

	@Override
	public List<IndividualRtInfoResponse> getIndividualRightList(IndividualRtInfoRequest individualRtInfoRequest) throws Exception {
		return stIndivRtBaseInfoMapper.getIndividualRightList(individualRtInfoRequest);
	}

	@Override
	public int getIndividualRightListCount(IndividualRtInfoRequest individualRtInfoRequest) throws Exception {
		return stIndivRtBaseInfoMapper.getIndividualRightListCount(individualRtInfoRequest);
	}

	@Override
	public List<RtTargetBaseResponse> getIndividualMenuTreeList(RtTargetBaseRequest rtTargetBaseRequest) throws Exception {
		int count = stRtTgtBaseMapper.getIndivMenuCheck(rtTargetBaseRequest);
		
		if (count > 0) {
			//rtTargetBaseRequest.setRtSubGbCd(UR006.);
			rtTargetBaseRequest.setRtSubGbCd("02");
			return stRtTgtBaseMapper.getIndividualMenuTreeListForUser(rtTargetBaseRequest);
		} else {//개별권한기본정보 테이블에만 데이터 존재하고 권한정보엔 없는 상태는 권한대상기본에서 모든 메뉴 조회
			return stRtTgtBaseMapper.getIndividualMenuTreeList(rtTargetBaseRequest);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void registCUD(List<StIndivRtBaseInfo> createList, List<StIndivRtBaseInfo> updateList) throws Exception {
		registIndividualRight(createList);
		updateIndividualRight(updateList);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void registIndividualRight(List<StIndivRtBaseInfo> createList) throws Exception {
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final String loginId = currentUser.getLoginId();
		
		for (StIndivRtBaseInfo stIndivRtBaseInfo : createList) {
			int check = stIndivRtBaseInfoMapper.getIndividualRightCountForCheck(stIndivRtBaseInfo.getUserId());
			if (check > 0) {
				Validator.throwIfNotNull(stIndivRtBaseInfo.getUserId(), "개별권한을 갖고있는 사용자가 존재합니다.");
			}
			
			Validator.throwIfEmpty(stIndivRtBaseInfo.getUserId(), MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] {"사용자ID"}));
			Validator.throwIfEmpty(stIndivRtBaseInfo.getAplyStrDt(), MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] {"적용시작일자"}));
			Validator.throwIfEmpty(stIndivRtBaseInfo.getAplyEndDt(), MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] {"적용종료일자"}));
			stIndivRtBaseInfoTrxMapper.saveStIndivRtBaseInfo(stIndivRtBaseInfo);
			
			StRtInfo stRtInfo = new StRtInfo();
	        stRtInfo.setRtGrpNo(stIndivRtBaseInfo.getUserId());
	        stRtInfo.setSysRegId(loginId);
	        stRtInfo.setSysModId(loginId);
	    	stRtInfoTrxMapper.saveStRtInfoIndiv(stRtInfo);
		}
	}

	@Override
	public void updateIndividualRight(List<StIndivRtBaseInfo> updateList) throws Exception {
		for (StIndivRtBaseInfo stIndivRtBaseInfo : updateList) {
			Validator.throwIfEmpty(stIndivRtBaseInfo.getIndivRtNo(), MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] {"개별권한번호"}));
			Validator.throwIfEmpty(stIndivRtBaseInfo.getUserId(), MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] {"사용자ID"}));
			Validator.throwIfEmpty(stIndivRtBaseInfo.getAplyStrDt(), MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] {"적용시작일자"}));
			Validator.throwIfEmpty(stIndivRtBaseInfo.getAplyEndDt(), MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] {"적용종료일자"}));
			stIndivRtBaseInfoTrxMapper.updateStIndivRtBaseInfo(stIndivRtBaseInfo);
		}
	}
	
	@Override
	public void updateIndividualButtonRight(List<StRtInfo> updateList) throws Exception {
		for (StRtInfo stRtInfo : updateList) {
			stRtInfo.setRtSubGbCd("02");
			stRtInfoTrxMapper.modifyStRtInfoUseYn(stRtInfo);
		}
	}

}