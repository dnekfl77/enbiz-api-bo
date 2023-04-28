package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.dto.request.system.GroupCodeRequest;
import com.enbiz.api.bo.app.dto.request.system.StandardCodeMlRequest;
import com.enbiz.api.bo.app.dto.request.system.StandardCodeRequest;
import com.enbiz.api.bo.app.dto.response.system.GroupCodeResponse;
import com.enbiz.api.bo.app.dto.response.system.StandardCodeMlResponse;
import com.enbiz.api.bo.app.dto.response.system.StandardCodeResponse;
import com.enbiz.api.bo.app.service.system.CommonCodeMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/system/commonCodeMgmt")
@Lazy
@RequiredArgsConstructor
public class CommonCodeMgmtController {
	private final CommonCodeMgmtService commonCodeMgmtService;

	/**
     * 그룹코드 목록 조회
     * @param groupCodeRequest
     * @return 그룹코드 목록
     * @throws Exception
     */
	@GetMapping("/getGroupCodeList")
	Response<List<GroupCodeResponse>> getGroupCodeList(GroupCodeRequest groupCodeRequest) {
		return new Response<List<GroupCodeResponse>>().setPayload(commonCodeMgmtService.getGroupCodeList(groupCodeRequest));
	}
	
	/**
     * 그룹코드 목록 수 조회
     * @param  groupCodeRequest
     * @return 그룹코드 목록 수
     * @throws Exception
     */
	@GetMapping("/getGroupCodeListCount")
	Response<Integer> getGroupCodeListCount(GroupCodeRequest groupCodeRequest) {
		return new Response<Integer>().setPayload(commonCodeMgmtService.getGroupCodeListCount(groupCodeRequest));
	}

	/**
     * 그룹코드 저장 처리
     * @param createList 신규 목록
     * @param updateList 수정 목록
     * @throws Exception
     */
	@PostMapping("/saveGroupCode")
	Response<String> saveGroupCode(@RequestBody RealGridCUDRequest<GroupCodeRequest> realGridCUD) throws Exception {
		List<GroupCodeRequest> createList = realGridCUD.getCreate(), updateList = realGridCUD.getUpdate();
		commonCodeMgmtService.saveGroupCode(createList, updateList);
		return new Response<String>().setPayload("success");
	}

    /**
     * 기준코드 목록 조회
     * @param  standardCodeRequest
     * @return 기준코드 목록
     * @throws Exception
     */
	@GetMapping("/getStandardCodeList")
	Response<List<StandardCodeResponse>> getStandardCodeList(StandardCodeRequest standardCodeRequest) {
		return new Response<List<StandardCodeResponse>>().setPayload(commonCodeMgmtService.getStandardCodeList(standardCodeRequest));
	}
	
	/**
     * 기준코드 목록 수 조회
     * @param  standardCodeRequest
     * @return 기준코드 목록
     * @throws Exception
     */
	@GetMapping("/getStandardCodeListCount")
	Response<Integer> getStandardCodeListCount(StandardCodeRequest standardCodeRequest) {
		return new Response<Integer>().setPayload(commonCodeMgmtService.getStandardCodeListCount(standardCodeRequest));
	}
	
	/**
     * 기준코드 저장 처리
     * @param createList 신규 목록
     * @param updateList 수정 목록
     * @throws Exception
     */
	@PostMapping("/saveStandardCode")
	Response<String> saveStandardCode(@RequestBody RealGridCUDRequest<StandardCodeRequest> realGridCUD) throws Exception {
		List<StandardCodeRequest> createList = realGridCUD.getCreate(), updateList = realGridCUD.getUpdate();
		commonCodeMgmtService.saveStandardCode(createList, updateList);
		return new Response<String>().setPayload("success");
    }
	
}
