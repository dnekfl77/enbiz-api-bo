package com.enbiz.api.bo.app.service.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.request.system.RtTargetBaseLogRequest;
import com.enbiz.api.bo.app.dto.response.system.RtTargetBaseLogResponse;
import com.enbiz.api.bo.app.repository.main.system.StRtTgtBaseLogMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Lazy
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MenuUsageStatusInquiryServiceImpl implements MenuUsageStatusInquiryService {
	private final StRtTgtBaseLogMapper stRtTgtBaseLogMapper;

	@Override
	public int getMenuUseStatusListCount(RtTargetBaseLogRequest RtTargetBaseLogRequest) throws Exception {
		return stRtTgtBaseLogMapper.getMenuUseStatusListCount(RtTargetBaseLogRequest);
	}

	@Override
	public List<RtTargetBaseLogResponse> getMenuUseStatusList(RtTargetBaseLogRequest RtTargetBaseLogRequest) throws Exception {
		return stRtTgtBaseLogMapper.getMenuUseStatusList(RtTargetBaseLogRequest);
	}

	@Override
	public int getUserMenuUseStatusListCount(RtTargetBaseLogRequest RtTargetBaseLogRequest) throws Exception {
		return stRtTgtBaseLogMapper.getUserMenuUseStatusListCount(RtTargetBaseLogRequest);
	}

	@Override
	public List<RtTargetBaseLogResponse> getUserMenuUseStatusList(RtTargetBaseLogRequest RtTargetBaseLogRequest) throws Exception {
		return stRtTgtBaseLogMapper.getUserMenuUseStatusList(RtTargetBaseLogRequest);
	}
}