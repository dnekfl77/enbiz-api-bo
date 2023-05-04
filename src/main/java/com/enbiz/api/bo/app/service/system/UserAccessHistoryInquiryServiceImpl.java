package com.enbiz.api.bo.app.service.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.request.system.LoginLogRequest;
import com.enbiz.api.bo.app.dto.response.system.LoginLogResponse;
import com.enbiz.api.bo.app.repository.main.system.StLoginLogMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Lazy
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserAccessHistoryInquiryServiceImpl implements UserAccessHistoryInquiryService {
	private final StLoginLogMapper stLoginLogMapper;

	@Override
	public int getLastLoginInfoListCount(LoginLogRequest stlogLoginLogRequest) throws Exception {
		return stLoginLogMapper.getLastLoginInfoListCount(stlogLoginLogRequest);
	}

	@Override
	public List<LoginLogResponse> getLastLoginInfoList(LoginLogRequest stlogLoginLogRequest) throws Exception {	
		return stLoginLogMapper.getLastLoginInfoList(stlogLoginLogRequest);
	}

	@Override
	public int getDetailLoginHistoryListCount(LoginLogRequest stlogLoginLogRequest) throws Exception {
		return stLoginLogMapper.getDetailLoginHistoryListCount(stlogLoginLogRequest);
	}

	@Override
	public List<LoginLogResponse> getDetailLoginHistoryList(LoginLogRequest stlogLoginLogRequest) throws Exception {
		return stLoginLogMapper.getDetailLoginHistoryList(stlogLoginLogRequest);
	}
}