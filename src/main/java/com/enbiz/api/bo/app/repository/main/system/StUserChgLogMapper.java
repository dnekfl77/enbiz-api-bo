package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;

@Repository
@Lazy
public interface StUserChgLogMapper {
	int getStUserChgLogPwdChgCnt(LoginRequest loginRequest) throws Exception;
}
