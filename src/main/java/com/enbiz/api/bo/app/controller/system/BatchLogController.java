package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.system.StBatchLogRequest;
import com.enbiz.api.bo.app.dto.response.system.StBatchLogResponse;
import com.enbiz.api.bo.app.service.system.BatchLogService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* 시스템 관리 / 배치로그
*/
@RestController
@RequestMapping("/system/batchLog")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class BatchLogController {
	
	private final BatchLogService batchLogService;
	
	@GetMapping("/getBatchLogListCount")
	Response<Integer> getBatchLogListCount(StBatchLogRequest stBatchLogRequest) throws Exception {
		return new Response<Integer>().setPayload(batchLogService.getBatchLogListCount(stBatchLogRequest));
	}
	
	@GetMapping("/getBatchLogList")
	Response<List<StBatchLogResponse>> getBatchList(StBatchLogRequest stBatchLogRequest) throws Exception {
		return new Response<List<StBatchLogResponse>>().setPayload(batchLogService.getBatchLogList(stBatchLogRequest));
	}
}