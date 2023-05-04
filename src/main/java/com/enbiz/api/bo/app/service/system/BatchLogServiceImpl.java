package com.enbiz.api.bo.app.service.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.request.system.StBatchLogRequest;
import com.enbiz.api.bo.app.dto.response.system.StBatchLogResponse;
import com.enbiz.api.bo.app.repository.main.system.StBatchLogMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Lazy
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BatchLogServiceImpl implements BatchLogService {
	
	private final StBatchLogMapper stBatchLogMapper;
	
	/**
	 * 배치 로그 목록 수 조회
	 * @param stMgrBatchBaseRequest
	 * @return 배치 목록 수
	 */
	@Override
	public int getBatchLogListCount(StBatchLogRequest stBatchLogRequest) throws Exception {
		return stBatchLogMapper.getBatchLogListCount(stBatchLogRequest);
	}
	
	/**
	 * 배치 로그 목록 조회
	 * @param stMgrBatchBaseRequest
	 * @return 배치 목록
	 */
	@Override
	public List<StBatchLogResponse> getBatchLogList(StBatchLogRequest stBatchLogRequest) throws Exception {
		return stBatchLogMapper.getBatchLogList(stBatchLogRequest);
	}
}