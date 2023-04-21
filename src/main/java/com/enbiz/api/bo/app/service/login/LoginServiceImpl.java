package com.enbiz.api.bo.app.service.login;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;
import com.enbiz.api.bo.app.dto.request.system.PasswordChangeRequest;
import com.enbiz.api.bo.app.dto.response.login.LoginResponse;
import com.enbiz.api.bo.app.dto.response.login.PrivacyPolicyInfo;
import com.enbiz.api.bo.app.entity.StLoginLog;
import com.enbiz.api.bo.app.entity.StUserBase;
import com.enbiz.api.bo.app.repository.main.system.StIndInfoQryRtInfoMapper;
import com.enbiz.api.bo.app.repository.main.system.StLoginLogTrxMapper;
import com.enbiz.api.bo.app.repository.main.system.StUserBaseMapper;
import com.enbiz.api.bo.app.repository.main.system.StUserBaseTrxMapper;
import com.enbiz.api.bo.app.service.system.StUserChgLogService;
import com.enbiz.common.base.exception.MessageResolver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Lazy
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService {

	private final StUserBaseMapper stUserBaseMapper;

	private final StUserBaseTrxMapper stUserBaseTrxMapper;

	private final StLoginLogTrxMapper stLoginLogTrxMapper;

	private final StUserChgLogService stUserChgLogService;

	private final StIndInfoQryRtInfoMapper stIndInfoQryRtInfoMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public LoginResponse getUserCertification(LoginRequest loginRequest) throws Exception {
		return stUserBaseMapper.getUserCertification(loginRequest);
	}

	@Override
	public void updateIdUnlock(LoginRequest loginRequest) throws Exception {
		StUserBase stUserBase = new StUserBase();

		stUserBase.setUserId(loginRequest.getLoginId());
		stUserBase.setSysRegId(loginRequest.getLoginId());

		stUserBaseTrxMapper.updateIdUnlock(stUserBase);
	}

	/**
	 * 3개월 이상 비로그인 잠금 설정
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void updateIdLockYnCheck(LoginRequest loginRequest) throws Exception {
		StUserBase stUserBase = new StUserBase();

		stUserBase.setUserId(loginRequest.getLoginId());
		stUserBase.setSysRegId(loginRequest.getLoginId());

		stUserBaseTrxMapper.updateIdLockYnCheck(stUserBase);
	}

	@Override
	public LoginResponse getStUserBaseExistsLogin(LoginRequest loginRequest) throws Exception {
		loginRequest.setUserId(loginRequest.getLoginId());

		// 아이디로만 조회한다.
		LoginResponse loginResponse = stUserBaseMapper.getStUserBaseExistsLogin(loginRequest);

		if (loginResponse != null) {
			// 패스워드 비교한다.
			if (passwordEncoder.matches(loginRequest.getPassword(), loginResponse.getPwd())) {
				List<PrivacyPolicyInfo> stIndInfoQryRtInfoList = stIndInfoQryRtInfoMapper
						.getStIndInfoQryRtInfoList(loginRequest.getUserId());

				if (stIndInfoQryRtInfoList != null && stIndInfoQryRtInfoList.size() > 0) {
					loginResponse.setPrivacyPolicyInfoList(stIndInfoQryRtInfoList);
				}
				return loginResponse;
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void updateLoginSuccess(LoginRequest loginRequest) throws Exception {
		StUserBase stUserBase = new StUserBase();

		stUserBase.setUserId(loginRequest.getLoginId());
		stUserBase.setSysRegId(loginRequest.getLoginId());

		stUserBaseTrxMapper.updateLoginSuccess(stUserBase);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void updateLoginFailCntAdd(LoginRequest loginRequest) throws Exception {
		StUserBase stUserBase = new StUserBase();

		stUserBase.setUserId(loginRequest.getLoginId());
		stUserBase.setSysRegId(loginRequest.getLoginId());

		stUserBaseTrxMapper.updateLoginSuccess(stUserBase);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void insertStLoginLog(StLoginLog stLoginLog) throws Exception {
		stLoginLogTrxMapper.insertStLoginLog(stLoginLog);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void updateStLoginLog(StLoginLog stLoginLog) throws Exception {
		stLoginLogTrxMapper.updateStLoginLog(stLoginLog);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void updatePasswordByPasswordInitialize(PasswordChangeRequest request) throws Exception {
		String encryptedCurrentPasswd = this.passwordEncoder.encode(request.getCurrentPasswd());
		if (!passwordConfirm(request.getUserId(), request.getCurrentPasswd())) {
			throw new ValidationException(
					MessageResolver.getMessage("adminCommon.changePassword.message.passwd.not.confirm"));
		}

		// 비밀번호변경
		String encryptedPasswd = this.passwordEncoder.encode(request.getNewPasswd());
		StUserBase userParam = new StUserBase();
		userParam.setUserId(request.getUserId());
		userParam.setPwd(encryptedPasswd);
		stUserBaseTrxMapper.updatePasswordByPasswordInitialize(userParam);

		// 변경로그
		stUserChgLogService.savePasswdChgLog(request.getUserId(), encryptedCurrentPasswd);
	}

	private boolean passwordConfirm(String userId, String passwd) {
		StUserBase confirmParam = new StUserBase();
		confirmParam.setUserId(userId);
		String dbPasswd = stUserBaseMapper.getPasswd(userId);
		return passwordEncoder.matches(passwd, dbPasswd);
	}

	@Override
	public LoginResponse getLoginUser(String loginId) throws Exception {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setLoginId(loginId);

		LoginResponse loginResponse = stUserBaseMapper.getStUserBaseExistsLogin(loginRequest);

		if (loginResponse != null) {
			List<PrivacyPolicyInfo> stIndInfoQryRtInfoList = stIndInfoQryRtInfoMapper
					.getStIndInfoQryRtInfoList(loginRequest.getUserId());

			if (stIndInfoQryRtInfoList != null && stIndInfoQryRtInfoList.size() > 0)
				loginResponse.setPrivacyPolicyInfoList(stIndInfoQryRtInfoList);
		}

		return loginResponse;
	}

}