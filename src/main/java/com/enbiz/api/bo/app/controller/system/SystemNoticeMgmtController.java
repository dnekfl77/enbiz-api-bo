package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.system.ModifySystemNoticeRequest;
import com.enbiz.api.bo.app.dto.request.system.RegisterSystemNoticeRequest;
import com.enbiz.api.bo.app.dto.request.system.SystemNoticeListRequest;
import com.enbiz.api.bo.app.dto.response.realgrid.RealGridListResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeInfoResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeListResponse;
import com.enbiz.api.bo.app.dto.response.system.SystemNoticeTargetInfoResponse;
import com.enbiz.api.bo.app.service.system.SystemNoticeMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/system/systemNoticeMgmt")
@Lazy
@RequiredArgsConstructor
public class SystemNoticeMgmtController {
	private final SystemNoticeMgmtService systemNoticeMgmtservice;

	/**
	 * 시스템공지수정
	 *
	 * @param req
	 * @param void
	 * @throws Exception
	 */
	@PutMapping("/modifySystemNoticeInfo")
	public Response<String> modifySystemNoticeInfo(@RequestBody ModifySystemNoticeRequest modifySystemNoticeRequest)
			throws Exception {
		systemNoticeMgmtservice.modifySystemNoticeInfo(modifySystemNoticeRequest.getReq(),
				modifySystemNoticeRequest.getCudList());
		return new Response<String>().setPayload("success");
	}

	@PostMapping("/registSystemNoticeInfo")
	public Response<String> registSystemNoticeInfo(@RequestBody RegisterSystemNoticeRequest registerSystemNoticeRequest)
			throws Exception {
		systemNoticeMgmtservice.registSystemNoticeInfo(registerSystemNoticeRequest.getReq(),
				registerSystemNoticeRequest.getCudList());
		return new Response<String>().setPayload("success");
	}

	@GetMapping("/getSystemNoticeInfo")
	public Response<SystemNoticeInfoResponse> getSystemNoticeInfo(String bbcNo) throws Exception {
		SystemNoticeInfoResponse response = systemNoticeMgmtservice.getSystemNoticeInfo(bbcNo);
		return new Response<SystemNoticeInfoResponse>().setPayload(response);
	}

	@GetMapping("/getSystemNoticeList")
	public Response<RealGridListResponse> getSystemNoticeList(
			SystemNoticeListRequest systemNoticeListRequest) {
		int totalCount = systemNoticeMgmtservice.getSystemNoticeListCount(systemNoticeListRequest);
		List<SystemNoticeListResponse> response = systemNoticeMgmtservice.getSystemNoticeList(systemNoticeListRequest);
		return new Response<RealGridListResponse>().setPayload(new RealGridListResponse(response, totalCount));
	}

	@GetMapping("/getSystemNoticeTargetInfoList")
	public Response<List<SystemNoticeTargetInfoResponse>> getSystemNoticeTargetInfoList(String bbcNo) {
		return new Response<List<SystemNoticeTargetInfoResponse>>()
				.setPayload(systemNoticeMgmtservice.getSystemNoticeTargetInfoList(bbcNo));
	}

//    /**
//     * 시스템공지 단건 조회
//     * @param bbcNo
//     * @return 시스템공지 단건
//     * @throws Exception
//     */
//    SystemNoticeInfoResponse getSystemNoticeInfo(String bbcNo) throws Exception;
//
//    /**
//     * 시스템공지 대상자 목록 조회
//     * @param bbcNo
//     * @return 시스템공지 대상자 목록
//     */
//    List<SystemNoticeTargetInfoResponse> getSystemNoticeTargetInfoList(String bbcNo);
//
//    /**
//     * 시스템공지 목록 조회
//     * @param systemNoticeListRequest
//     * @return 시스템공지 목록
//     */
//    List<SystemNoticeListResponse> getSystemNoticeList(SystemNoticeListRequest systemNoticeListRequest);
//
//    /**
//     * 시스템공지 목록수 조회
//     * @param systemNoticeListRequest
//     * @return 시스템공지 목록수
//     */
//    int getSystemNoticeListCount(SystemNoticeListRequest systemNoticeListRequest);
//
//    /**
//     * 대시보드 시스템공지 목록 조회
//     * @param dashboardNoticeRequest
//     * @return 대시보드 시스템공지 목록
//     */
//    List<DashboardNoticeResponse> getSystemNoticeInfoListByToday(DashboardNoticeRequest dashboardNoticeRequest);
//
//    /**
//     * 대시보스 시스템공지 상세 조회
//     * @param dashboardNoticeRequest
//     * @return 대시보스 시스템공지 상세
//     */
//    DashboardNoticeResponse getSystemNoticeInfoListByTodayDetail(DashboardNoticeRequest dashboardNoticeRequest);
//
//    /**
//     * 시스템공지 첨부파일 목록 조회
//     * @param bbcNo
//     * @return 시스템공지 첨부파일
//     */
//    List<SystemNoticeAttachFileResponse> getAttachFileList(String bbcNo);
//
}
