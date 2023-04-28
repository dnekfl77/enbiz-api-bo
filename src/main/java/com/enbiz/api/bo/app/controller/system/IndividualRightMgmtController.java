package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.dto.request.system.IndividualRtInfoRequest;
import com.enbiz.api.bo.app.dto.request.system.RtTargetBaseRequest;
import com.enbiz.api.bo.app.dto.response.system.IndividualRtInfoResponse;
import com.enbiz.api.bo.app.dto.response.system.RtTargetBaseResponse;
import com.enbiz.api.bo.app.entity.StIndivRtBaseInfo;
import com.enbiz.api.bo.app.entity.StRtInfo;
import com.enbiz.api.bo.app.service.system.IndividualRightMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/system/individualRightMgmt")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class IndividualRightMgmtController {
	
	private final IndividualRightMgmtService individualRightMgmtService;
	
	@PostMapping("/getIndividualRightList")
	public Response<List<IndividualRtInfoResponse>> getIndividualRightList(IndividualRtInfoRequest individualRtInfoRequest) throws Exception {
		
		return new Response<List<IndividualRtInfoResponse>>().setPayload(individualRightMgmtService.getIndividualRightList(individualRtInfoRequest));
	}

	@GetMapping("/getIndividualRightListCount")
	public Response<Integer> getDisplayTemplateListCount(IndividualRtInfoRequest individualRtInfoRequest) throws Exception {
		return new Response<Integer>().setPayload(individualRightMgmtService.getIndividualRightListCount(individualRtInfoRequest));
	}
	
	@GetMapping("/getIndividualMenuTreeList")
	 public Response<List<RtTargetBaseResponse>> getIndividualMenuTreeList(RtTargetBaseRequest rtTargetBaseRequest) throws Exception {
    	return new Response<List<RtTargetBaseResponse>>().setPayload(individualRightMgmtService.getIndividualMenuTreeList(rtTargetBaseRequest));
    }
	
	@PostMapping("/saveIndividualRightList")
	public Response<String> saveIndividualRightList(@RequestBody RealGridCUDRequest<StIndivRtBaseInfo> realGridCUD) throws Exception {
		List<StIndivRtBaseInfo> createList = realGridCUD.getCreate(), updateList = realGridCUD.getUpdate();
		individualRightMgmtService.registCUD(createList, updateList);
		return new Response<String>().setPayload("success");
	}
	
	@PostMapping("/saveIndividualRightButtonGridList")
	public Response<String> saveIndividualRightButtonGridList(@RequestBody RealGridCUDRequest<StRtInfo> realGridCUD) throws Exception {
		List<StRtInfo> updateList = realGridCUD.getUpdate();
		individualRightMgmtService.updateIndividualButtonRight(updateList);
		return new Response<String>().setPayload("success");
	}
	
}