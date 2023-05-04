package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.dto.request.system.UserFavoriteMenuRequest;
import com.enbiz.api.bo.app.dto.response.system.UserFavoriteMenuResponse;
import com.enbiz.api.bo.app.entity.StUserFvtInfo;
import com.enbiz.api.bo.app.service.system.UserFavoriteMenuMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 시스템 관리 / 개인관리 / 즐겨찾기관리
 */
@RestController
@RequestMapping("/system/userFavoriteMenuMgmt")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class UserFavoriteMenuMgmtController {

	private final UserFavoriteMenuMgmtService userFavoriteMenuMgmtService;

	/**
	 * 즐겨찾기 그룹 목록 조회
	 * @param userFavoriteMenuRequest
	 * @return 즐겨찾기 그룹 목록 리스트
	 * @throws Exception
	 */
    @GetMapping("/getUserFavoriteMenuList")
    public Response<List<UserFavoriteMenuResponse>> getUserFavoriteMenuList(UserFavoriteMenuRequest userFavoriteMenuRequest) throws Exception {
    	return new Response<List<UserFavoriteMenuResponse>>().setPayload(userFavoriteMenuMgmtService.getUserFavoriteMenuList(userFavoriteMenuRequest));
    }
    @GetMapping("/getUserFavoriteMenuListCount")
    public Response<Integer> getUserFavoriteMenuListCount(UserFavoriteMenuRequest userFavoriteMenuRequest) throws Exception {
    	return new Response<Integer>().setPayload(userFavoriteMenuMgmtService.getUserFavoriteMenuListCount(userFavoriteMenuRequest));
    }

	/**
	 * 즐겨찾기 그룹 목록 수정 삭제
	 * @param realGridCUD
	 * @return 성공 메시지
	 * @throws Exception
	 */
    @PostMapping("/saveUserFavoriteMenu")
    public Response<String> saveUserFavoriteMenu(@RequestBody RealGridCUDRequest<StUserFvtInfo> realGridCUD) throws Exception {
    	List<StUserFvtInfo> updateList = realGridCUD.getUpdate(), deleteList = realGridCUD.getDelete();
    	userFavoriteMenuMgmtService.saveUserFavoriteMenu(updateList, deleteList);
        return new Response<String>().setPayload("success");
    }
}
