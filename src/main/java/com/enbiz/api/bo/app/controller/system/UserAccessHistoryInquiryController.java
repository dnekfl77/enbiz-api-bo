package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.system.LoginLogRequest;
import com.enbiz.api.bo.app.dto.response.system.LoginLogResponse;
import com.enbiz.api.bo.app.service.system.UserAccessHistoryInquiryService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* 시스템 관리 / 배치로그
*/
@RestController
@RequestMapping("/system/userAccessHistoryInquiry")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class UserAccessHistoryInquiryController {
	private final UserAccessHistoryInquiryService userAccessHistoryInquiryService;
	
	@GetMapping("/getLastLoginInfoListCount")
	Response<Integer> getLastLoginInfoListCount(LoginLogRequest stlogLoginLogRequest) throws Exception {
		return new Response<Integer>().setPayload(userAccessHistoryInquiryService.getLastLoginInfoListCount(stlogLoginLogRequest));
	}
	
	@GetMapping("/getLastLoginInfoList")
	Response<List<LoginLogResponse>> getLastLoginInfoList(LoginLogRequest stlogLoginLogRequest) throws Exception {
		return new Response<List<LoginLogResponse>>().setPayload(userAccessHistoryInquiryService.getLastLoginInfoList(stlogLoginLogRequest));
	}
	
	@GetMapping("/getDetailLoginHistoryListCount")
	Response<Integer> getDetailLoginHistoryListCount(LoginLogRequest stlogLoginLogRequest) throws Exception {
		return new Response<Integer>().setPayload(userAccessHistoryInquiryService.getDetailLoginHistoryListCount(stlogLoginLogRequest));
	}
	
	@GetMapping("/getDetailLoginHistoryList")
	Response<List<LoginLogResponse>> getDetailLoginHistoryList(LoginLogRequest stlogLoginLogRequest) throws Exception {
		return new Response<List<LoginLogResponse>>().setPayload(userAccessHistoryInquiryService.getDetailLoginHistoryList(stlogLoginLogRequest));
	}
}