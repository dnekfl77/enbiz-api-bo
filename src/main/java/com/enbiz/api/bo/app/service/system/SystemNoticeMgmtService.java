package com.enbiz.api.bo.app.service.system;

import java.util.List;

import com.enbiz.api.bo.app.dto.request.dashboard.DashboardNoticeRequest;
import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.dto.request.system.SystemNoticeCudRequest;
import com.enbiz.api.bo.app.dto.request.system.SystemNoticeListRequest;
import com.enbiz.api.bo.app.dto.response.dashboard.DashboardNoticeResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeAttachFileResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeInfoResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeListResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeTargetInfoResponse;
import com.enbiz.api.bo.app.entity.StUserBase;

public interface SystemNoticeMgmtService {
	/**
	 * 시스템공지저장
	 * 
	 * @param req
	 * @param void
	 * @throws Exception
	 */
	void registSystemNoticeInfo(SystemNoticeCudRequest req, RealGridCUDRequest<StUserBase> cudList) throws Exception;

	/**
	 * 시스템공지수정
	 * 
	 * @param req
	 * @param void
	 * @throws Exception
	 */
	void modifySystemNoticeInfo(SystemNoticeCudRequest req, RealGridCUDRequest<StUserBase> cudList) throws Exception;

	/**
	 * 시스템공지 단건 조회
	 * 
	 * @param bbcNo
	 * @return 시스템공지 단건
	 * @throws Exception
	 */
	SystemNoticeInfoResponse getSystemNoticeInfo(String bbcNo) throws Exception;

	/**
	 * 시스템공지 대상자 목록 조회
	 * 
	 * @param bbcNo
	 * @return 시스템공지 대상자 목록
	 */
	List<SystemNoticeTargetInfoResponse> getSystemNoticeTargetInfoList(String bbcNo);

	/**
	 * 시스템공지 목록 조회
	 * 
	 * @param systemNoticeListRequest
	 * @return 시스템공지 목록
	 */
	List<SystemNoticeListResponse> getSystemNoticeList(SystemNoticeListRequest systemNoticeListRequest);

	/**
	 * 시스템공지 목록수 조회
	 * 
	 * @param systemNoticeListRequest
	 * @return 시스템공지 목록수
	 */
	int getSystemNoticeListCount(SystemNoticeListRequest systemNoticeListRequest);

	/**
	 * 대시보드 시스템공지 목록 조회
	 * 
	 * @param dashboardNoticeRequest
	 * @return 대시보드 시스템공지 목록
	 */
	List<DashboardNoticeResponse> getSystemNoticeInfoListByToday(DashboardNoticeRequest dashboardNoticeRequest);

	/**
	 * 대시보스 시스템공지 상세 조회
	 * 
	 * @param dashboardNoticeRequest
	 * @return 대시보스 시스템공지 상세
	 */
	DashboardNoticeResponse getSystemNoticeInfoListByTodayDetail(DashboardNoticeRequest dashboardNoticeRequest);

	/**
	 * 시스템공지 첨부파일 목록 조회
	 * 
	 * @param bbcNo
	 * @return 시스템공지 첨부파일
	 */
	List<SystemNoticeAttachFileResponse> getAttachFileList(String bbcNo);
}
