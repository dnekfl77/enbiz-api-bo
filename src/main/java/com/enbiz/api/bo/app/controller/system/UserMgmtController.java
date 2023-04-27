package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.Lazy;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.system.UserDetailRequest;
import com.enbiz.api.bo.app.dto.request.system.UserListRequest;
import com.enbiz.api.bo.app.dto.request.system.UserRightGroupRequest;
import com.enbiz.api.bo.app.dto.response.system.UserDetailResponse;
import com.enbiz.api.bo.app.dto.response.system.UserListResponse;
import com.enbiz.api.bo.app.dto.response.system.UserRightGroupResponse;
import com.enbiz.api.bo.app.service.system.UserMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 시스템 관리 / 사용자관리
 */
@RestController
@RequestMapping("/system/userMgmt")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class UserMgmtController {

	private final UserMgmtService userMgmtService;

	/**
	 * 조회 조건에 맞는 사용자요약정보 목록 조회
	 *
	 * @param userListRequest
	 * @return 사용자요약정보 목록
	 * @throws
	 */
	@GetMapping("/getUserListInUserMenu")
	Response<List<UserListResponse>> getUserListInUserMenu(UserListRequest userListRequest) throws Exception {
		return new Response<List<UserListResponse>>().setPayload(userMgmtService.getUserListInUserMenu(userListRequest));
	}

	/**
	 * 조회 조건에 맞는 사용자요약정보 목록 조회
	 *
	 * @param userListRequest
	 * @return 사용자요약정보 목록
	 * @throws
	 */
	@GetMapping("/getUserListInUserMenuCount")
	Response<Integer> getUserListInUserMenuCount(UserListRequest userListRequest) throws Exception {
		//return new Response<Integer>().setPayload(commonCodeMgmtService.getGroupCodeListCount(groupCodeRequest));
		return new Response<Integer>().setPayload(userMgmtService.getUserListInUserMenuCount(userListRequest));
	}
	
	/**
	 * 사용자 정보 조회
	 *
	 * @param
	 * @return 사용자 목록
	 * @throws
	 */
	@GetMapping("/getUserDetail")
	Response<UserDetailResponse> getUserDetail(@RequestParam String userId) throws Exception {
		return new Response<UserDetailResponse>().setPayload(userMgmtService.getUserDetail(userId));
	}
	
	/**
	 * 사용자 카운트 조회
	 *
	 * @param
	 * @return 사용자 카운트
	 * @throws
	 */
	@GetMapping("/getUserCount")
	Response<Integer> getUserCount(@RequestParam @Nullable String userId) throws Exception {
		int count = 0;
		count = userMgmtService.getUserCount(userId);
		return new Response<Integer>().setPayload(count);
	}

	/**
	 * 비밀번호 잠김 해제
	 *
	 * @param
	 * @return 업데이트된 사용자 정보
	 * @throws
	 */
	@PostMapping("/modifyUpdatePwdUnlock")
	Response<UserDetailResponse> modifyUpdatePwdUnlock(@RequestBody String userId) throws Exception {
		return new Response<UserDetailResponse>().setPayload(userMgmtService.unlockPassword(userId));
	}
	
	/**
	 * 비밀번호 초기화
	 *
	 * @param
	 * @return 업데이트된 사용자 정보
	 * @throws
	 */
	@PostMapping("/modifyInitializePassword")
	Response<UserDetailResponse> modifyInitializePassword(@RequestBody String userId) throws Exception {
		return new Response<UserDetailResponse>().setPayload(userMgmtService.initializePassword(userId));
	}
	
	/**
	 * 사용자 저장
	 * */
	@PostMapping("/saveUser")
	Response<UserDetailResponse> saveUser(@RequestBody UserDetailRequest request) throws Exception {
		return new Response<UserDetailResponse>().setPayload(userMgmtService.saveUser(request));
	}
	
    /**
     * 사용자 권한그룹 목록 조회
     *
     * @param request
     * @return 권한그룹 목록
     */
	@GetMapping("/getUserRightGroupInfo")
	Response<List<UserRightGroupResponse>> getUserRightGroupInfo(UserRightGroupRequest userRightGroupRequest) throws Exception {
		return new Response<List<UserRightGroupResponse>>().setPayload(userMgmtService.getUserRightGroupInfo(userRightGroupRequest));
	}
	
	@GetMapping("/getUserRightGroupListCount")
	Response<Integer> getUserRightGroupListCount(UserRightGroupRequest userRightGroupRequest) throws Exception {
		return new Response<Integer>().setPayload(userMgmtService.getUserRightGroupListCount(userRightGroupRequest));
	}

}
