package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.system.RtTargetBaseLogRequest;
import com.enbiz.api.bo.app.dto.response.system.RtTargetBaseLogResponse;
import com.enbiz.api.bo.app.service.system.MenuUsageStatusInquiryService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 시스템 관리 -> 모니터링 관리 -> 메뉴별사용현황조회
 */

@RestController
@RequestMapping("/system/menuUsageStatusInquiry")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class MenuUsageStatusInquiryController {
	
	private final MenuUsageStatusInquiryService menuUsageStatusInquiryService;
	
	@GetMapping("/getMenuUseStatusListCount")
	Response<Integer> getMenuUseStatusListCount(RtTargetBaseLogRequest rtTargetBaseLogRequest) throws Exception {
		return new Response<Integer>().setPayload(menuUsageStatusInquiryService.getMenuUseStatusListCount(rtTargetBaseLogRequest));
	}
	
	@GetMapping("/getMenuUseStatusList")
	Response<List<RtTargetBaseLogResponse>> getMenuUseStatusList(RtTargetBaseLogRequest rtTargetBaseLogRequest) throws Exception {
		return new Response<List<RtTargetBaseLogResponse>>().setPayload(menuUsageStatusInquiryService.getMenuUseStatusList(rtTargetBaseLogRequest));
	}
	
	@GetMapping("/getUserMenuUseStatusListCount")
	Response<Integer> getUserMenuUseStatusListCount(RtTargetBaseLogRequest rtTargetBaseLogRequest) throws Exception {
		return new Response<Integer>().setPayload(menuUsageStatusInquiryService.getUserMenuUseStatusListCount(rtTargetBaseLogRequest));
	}
	
	@GetMapping("/getUserMenuUseStatusList")
	Response<List<RtTargetBaseLogResponse>> getUserMenuUseStatusList(RtTargetBaseLogRequest rtTargetBaseLogRequest) throws Exception {
		return new Response<List<RtTargetBaseLogResponse>>().setPayload(menuUsageStatusInquiryService.getUserMenuUseStatusList(rtTargetBaseLogRequest));
	}
}