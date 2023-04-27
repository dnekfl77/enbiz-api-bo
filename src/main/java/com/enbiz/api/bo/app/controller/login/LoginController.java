package com.enbiz.api.bo.app.controller.login;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;
import com.enbiz.api.bo.app.dto.request.system.PasswordChangeRequest;
import com.enbiz.api.bo.app.dto.response.login.LoginResponse;
import com.enbiz.api.bo.app.entity.StLoginLog;
import com.enbiz.api.bo.app.service.login.LoginService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;

@RestController
@Lazy
@RequiredArgsConstructor
@RequestMapping("/login/login")
public class LoginController {
	private final LoginService loginService;

	/**
	 * 유효한 사용자 인증
	 * 
	 * @param loginRequest
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/getUserCertification")
	public Response<LoginResponse> getUserCertification( LoginRequest loginRequest) throws Exception {
		return new Response<LoginResponse>().setPayload(loginService.getUserCertification(loginRequest));
	}

	/**
	 * 비밀번호 찾기 시 아이디 잠금 해제
	 * 
	 * @param loginRequest
	 * @throws Exception
	 */
	@PutMapping("/updateIdUnlock")
	public Response<String> updateIdUnlock(@RequestBody LoginRequest loginRequest) throws Exception {
		loginService.updateIdUnlock(loginRequest);
		return new Response<String>();
	}

	/**
	 * 3개월 이상 비로그인 잠금 설정
	 * 
	 * @param loginRequest
	 * @throws Exception
	 */
	@PutMapping("/updateIdLockYnCheck")
	public Response<String> updateIdLockYnCheck(@RequestBody LoginRequest loginRequest) throws Exception {
		loginService.updateIdLockYnCheck(loginRequest);
		return new Response<String>();
	}

	/**
	 * 로그인했던 이력을 조회
	 * 
	 * @param loginRequest
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/getStUserBaseExistsLogin")
	public Response<LoginResponse> getStUserBaseExistsLogin(LoginRequest loginRequest) throws Exception {
		return new Response<LoginResponse>().setPayload(loginService.getStUserBaseExistsLogin(loginRequest));
	}

	/**
	 * 로그인 성공 업데이트
	 * 
	 * @param loginRequest
	 * @throws Exception
	 */
	@PutMapping("/updateLoginSuccess")
	public Response<String> updateLoginSuccess(@RequestBody LoginRequest loginRequest) throws Exception {
		loginService.updateLoginSuccess(loginRequest);
		return new Response<String>();

	}

	/**
	 * 로그인 실패 횟수 증가
	 * 
	 * @param loginRequest
	 * @throws Exception
	 */
	@PutMapping("/updateLoginFailCntAdd")
	public Response<String> updateLoginFailCntAdd(@RequestBody LoginRequest loginRequest) throws Exception {
		loginService.updateLoginFailCntAdd(loginRequest);
		return new Response<String>();
	}

	/**
	 * 로그인 로그 생성
	 * 
	 * @param stLoginLog
	 * @throws Exception
	 */
	@PostMapping("/insertStLoginLog")
	public Response<String> insertStLoginLog(@RequestBody StLoginLog stLoginLog) throws Exception {
		loginService.insertStLoginLog(stLoginLog);
		return new Response<String>();
	}

	/**
	 * 로그 아웃 로그
	 * 
	 * @param stLoginLog
	 * @throws Exception
	 */
	@PutMapping("/updateStLoginLog")
	public Response<String> updateStLoginLog(@RequestBody StLoginLog stLoginLog) throws Exception {
		loginService.updateStLoginLog(stLoginLog);
		return new Response<String>();
	}

	@PutMapping("/updatePasswordByPasswordInitialize")
	public Response<String> updatePasswordByPasswordInitialize(@RequestBody PasswordChangeRequest request)
			throws Exception {
		loginService.updatePasswordByPasswordInitialize(request);
		return new Response<String>();
	}

	@GetMapping("/getLoginUser")
	public Response<LoginResponse> getLoginUser( LoginRequest loginRequest) throws Exception {
		return new Response<LoginResponse>().setPayload(loginService.getLoginUser(loginRequest.getLoginId()));
	}

}
