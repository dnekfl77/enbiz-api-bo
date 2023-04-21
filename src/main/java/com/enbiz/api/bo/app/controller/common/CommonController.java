package com.enbiz.api.bo.app.controller.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;
import com.enbiz.api.bo.app.entity.StIndInfoQryLog;
import com.enbiz.api.bo.app.entity.StRtTgtBase;
import com.enbiz.api.bo.app.entity.StRtTgtBaseLog;
import com.enbiz.api.bo.app.service.common.AdminGroupService;
import com.enbiz.api.bo.app.service.system.MonitoringMgmtService;
import com.enbiz.api.bo.app.service.system.PersonInfoLogMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;

@RestController
@Lazy
@RequiredArgsConstructor
@RequestMapping("/common/common")
public class CommonController {
	private final AdminGroupService adminGroupService;
	private final MonitoringMgmtService monitoringMgmtService;
	private final PersonInfoLogMgmtService personInfoLogMgmtService;

	/**
	 * URL 권한 조회
	 * 
	 * @param loginRequest
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/getAdminGroups")
	public Response<Integer> getAdminGroups(@RequestBody LoginRequest loginRequest) throws Exception {
		return new Response<Integer>().setPayload(adminGroupService.getAdminGroups(loginRequest));
	}

	/**
	 * 접속한 Url의 RtTgtSeq조회 및 개인정보 유무 조회
	 * 
	 * @throws Exception
	 */
	@GetMapping("/getRtTgtSeqByStRtTgtBase")
	public Response<StRtTgtBase> getRtTgtSeqByStRtTgtBase(@RequestBody StRtTgtBase stRtTgtBase) throws Exception {
		StRtTgtBase data = monitoringMgmtService.getRtTgtSeqByStRtTgtBase(stRtTgtBase);
		Response<StRtTgtBase> response = new Response<StRtTgtBase>().setPayload(data);
		return response;
	}

	@PostMapping("/insertStRtTgtBaseLog")
	public Response<String> insertStRtTgtBaseLog(@RequestBody StRtTgtBaseLog stRtTgtBaseLog) throws Exception {
		monitoringMgmtService.insertStRtTgtBaseLog(stRtTgtBaseLog);
		return new Response<String>().setPayload("success");
	}

	@PostMapping("/insertStIndInfoQryLog")
	public Response<String> insertStIndInfoQryLog(@RequestBody StIndInfoQryLog stIndInfoQryLog) throws Exception {
		personInfoLogMgmtService.insertStIndInfoQryLog(stIndInfoQryLog);
		return new Response<String>().setPayload("success");
	}
}
