package com.enbiz.api.bo.app.service.common;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;

public interface AdminGroupService {
	int getAdminGroups(LoginRequest adminUser) throws Exception;
}
