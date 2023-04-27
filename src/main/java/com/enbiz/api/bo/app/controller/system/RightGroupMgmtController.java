package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.dto.request.system.RightGroupBaseRequest;
import com.enbiz.api.bo.app.dto.request.system.RightTargetBaseMenuRequest;
import com.enbiz.api.bo.app.dto.request.system.ZipNoMgmtRequest;
import com.enbiz.api.bo.app.dto.response.system.RightGroupBaseResponse;
import com.enbiz.api.bo.app.dto.response.system.RightTargetBaseMenuResponse;
import com.enbiz.api.bo.app.entity.StHoliInfo;
import com.enbiz.api.bo.app.service.system.RightGroupMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/system/rightGroupMgmt")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class RightGroupMgmtController {
	private final RightGroupMgmtService rightGroupMgmtService;
	    
    /**
     * 권한 그룹 목록 조회
     * @param  RightGroupBaseRequest
     * @return 권한 그룹 목록
     * @throws Exception
     */
    @GetMapping("/getRightGroupBaseList")
    public Response<List<RightGroupBaseResponse>> getRightGroupBaseList(RightGroupBaseRequest RightGroupBaseRequest) throws Exception {
        return new Response<List<RightGroupBaseResponse>>().setPayload(rightGroupMgmtService.getRightGroupBaseList(RightGroupBaseRequest));
    }

	/**
     * 권한 그룹 목록 수 조회
     * @param  RightGroupBaseRequest
     * @return 권한 그룹 목록 수
     * @throws Exception
     */
    @GetMapping("/getRightGroupBaseListCount")
    public Response<Integer> getRightGroupBaseListCount(RightGroupBaseRequest RightGroupBaseRequest) throws Exception {
        return new Response<Integer>().setPayload(rightGroupMgmtService.getRightGroupBaseListCount(RightGroupBaseRequest));
    }

	/**
     * 권한 그룹 저장 처리
     * @param createList 신규 목록
     * @param updateList 수정 목록
     * @throws Exception
     */
    @PostMapping("/saveRightGroupBaseList")
    public Response<String> saveRightGroupBaseList(@RequestBody RealGridCUDRequest<RightGroupBaseRequest> realGridCUD) throws Exception {
    	List<RightGroupBaseRequest> createList = realGridCUD.getCreate(), updateList = realGridCUD.getUpdate();
    	rightGroupMgmtService.saveRightGroupBaseList(createList, updateList);
    	return new Response<String>().setPayload("success");
    }
	
    /**
     * 권한 그룹 메뉴 조회
     * @param  stRtTgtMenuRequest
     * @return 권한 그룹 목록
     * @throws Exception
     */
    @GetMapping("/getRightTargetBaseMenuList")
    public Response<List<RightTargetBaseMenuResponse>> getRightTargetBaseMenuList(RightTargetBaseMenuRequest stRtTgtMenuRequest) throws Exception {
        return new Response<List<RightTargetBaseMenuResponse>>().setPayload(rightGroupMgmtService.getRightTargetBaseMenuList(stRtTgtMenuRequest));
    }

	/**
     * 권한 그룹 메뉴 수 조회
     * @param  stRtTgtMenuRequest
     * @return 권한 그룹 목록 수
     * @throws Exception
     */
    @GetMapping("/getRightTargetBaseMenuListCount")
    public Response<Integer> getRightTargetBaseMenuListCount(RightTargetBaseMenuRequest stRtTgtMenuRequest) throws Exception {
        return new Response<Integer>().setPayload(rightGroupMgmtService.getRightTargetBaseMenuListCount(stRtTgtMenuRequest));
    }

	/**
	 * 권한 그룹 메뉴 저장 처리
	 * @param updateList 수정 목록
	 * @throws Exception
	 */
    @PostMapping("/saveRightTargetBaseMenu")
    public Response<String> saveRightTargetBaseMenu(@RequestBody List<RightTargetBaseMenuRequest> updateList) throws Exception {
    	rightGroupMgmtService.saveRightTargetBaseMenu(updateList);
    	return new Response<String>().setPayload("success");
    }

	/**
     * 권한 그룹 버튼 조회
     * @param  stRtTgtMenuRequest
     * @return 권한 그룹 버튼 조회
     * @throws Exception
     */
    @GetMapping("/getRightGroupButtonList")
    public Response<List<RightTargetBaseMenuResponse>> getRightGroupButtonList(RightTargetBaseMenuRequest stRtTgtMenuRequest) throws Exception {
        return new Response<List<RightTargetBaseMenuResponse>>().setPayload(rightGroupMgmtService.getRightGroupButtonList(stRtTgtMenuRequest));
    }

	/**
     * 권한 그룹 버튼 수 조회
     * @param  stRtTgtMenuRequest
     * @return 권한 그룹 버튼 수 조회
     * @throws Exception
     */
    @GetMapping("/getRightGroupButtonListCount")
    public Response<Integer> getRightGroupButtonListCount(RightTargetBaseMenuRequest stRtTgtMenuRequest) throws Exception {
        return new Response<Integer>().setPayload(rightGroupMgmtService.getRightGroupButtonListCount(stRtTgtMenuRequest));
    }

}