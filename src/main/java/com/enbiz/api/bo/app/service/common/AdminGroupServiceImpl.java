package com.enbiz.api.bo.app.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;
import com.enbiz.api.bo.app.repository.main.system.StRtTgtBaseMapper;

@Service
@Lazy
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminGroupServiceImpl implements AdminGroupService {

	@Autowired
	private StRtTgtBaseMapper stRtTgtBaseMapper;

	@Override
	public int getAdminGroups(LoginRequest loginRequest) throws Exception {
		return 1;
		// return stRtTgtBaseMapper.getAdminGroupList(loginRequest);
	}
}
