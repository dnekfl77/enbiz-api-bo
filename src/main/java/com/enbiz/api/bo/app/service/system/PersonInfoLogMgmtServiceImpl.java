package com.enbiz.api.bo.app.service.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.entity.StIndInfoQryLog;
import com.enbiz.api.bo.app.repository.main.system.StIndInfoQryLogMapper;

import lombok.RequiredArgsConstructor;

/**
 * 개인정보 관련 메뉴 로그 기록
 */
@Service
@Lazy
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PersonInfoLogMgmtServiceImpl implements PersonInfoLogMgmtService {

	private final StIndInfoQryLogMapper stIndInfoQryLogMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void insertStIndInfoQryLog(StIndInfoQryLog stIndInfoQryLog) throws Exception {
		stIndInfoQryLogMapper.insertStIndInfoQryLog(stIndInfoQryLog);
	}

}
