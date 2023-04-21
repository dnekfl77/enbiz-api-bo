package com.enbiz.api.bo.app.controller.main;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;
import com.enbiz.api.bo.app.dto.request.menu.TopMenuRequest;
import com.enbiz.api.bo.app.dto.request.system.UserFavoriteMenuRequest;
import com.enbiz.api.bo.app.dto.response.menu.LeftMenuResponse;
import com.enbiz.api.bo.app.dto.response.menu.TopMenuResponse;
import com.enbiz.api.bo.app.service.main.MainService;
import com.enbiz.api.bo.app.service.system.UserFavoriteMenuMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;

@RestController
@Lazy
@RequiredArgsConstructor
@RequestMapping("/main/main")
public class MainController {
	private final MainService mainService;
	private final UserFavoriteMenuMgmtService userFavoriteMenuMgmtService;

	/**
	 * 유효한 사용자 인증
	 * 
	 * @param loginRequest
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/getTopMenuList")
	public Response<List<TopMenuResponse>> getTopMenuList(@RequestBody LoginRequest loginRequest) throws Exception {
		return new Response<List<TopMenuResponse>>().setPayload(mainService.getTopMenuList(loginRequest));
	}

	/**
	 * 비밀번호 찾기 시 아이디 잠금 해제
	 * 
	 * @param loginRequest
	 * @throws Exception
	 */
	@GetMapping("/getLeftMenuList")
	public Response<List<LeftMenuResponse>> getLeftMenuList(@RequestBody TopMenuRequest topMenuRequest)
			throws Exception {
		return new Response<List<LeftMenuResponse>>().setPayload(mainService.getLeftMenuList(topMenuRequest));
	}

	/**
	 * 즐겨찾기 메뉴 조회
	 * 
	 * @param topMenuRequest
	 * @throws Exception
	 */
	@GetMapping("/getFavoriteMenu")
	public Response<List<LeftMenuResponse>> getFavoriteMenu(@RequestBody TopMenuRequest topMenuRequest)
			throws Exception {
		List<LeftMenuResponse> response = userFavoriteMenuMgmtService.getFavoriteMenu(topMenuRequest);
		return new Response<List<LeftMenuResponse>>().setPayload(response);
	}

	/**
	 * 즐겨찾기 메뉴 중복 조회
	 * 
	 * @param topMenuRequest
	 * @throws Exception
	 */
	@GetMapping("/checkDuplicateUserFavoriteMenu")
	public Response<Integer> checkDuplicateUserFavoriteMenu(
			@RequestBody UserFavoriteMenuRequest userFavoriteMenuRequest) throws Exception {
		int result = userFavoriteMenuMgmtService.checkDuplicateUserFavoriteMenu(userFavoriteMenuRequest);
		return new Response<Integer>().setPayload(result);
	}

	/**
	 * 즐겨찾기 메뉴 등록
	 * 
	 * @param topMenuRequest
	 * @throws Exception
	 */
	@PostMapping("/registUserFavoriteMenu")
	public Response<String> registUserFavoriteMenu(@RequestBody UserFavoriteMenuRequest userFavoriteMenuRequest)
			throws Exception {
		userFavoriteMenuMgmtService.registUserFavoriteMenu(userFavoriteMenuRequest);
		return new Response<String>().setPayload("success");
	}
}
