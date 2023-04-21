package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.system.RtTargetBaseLogRequest;
import com.enbiz.api.bo.app.dto.response.system.RtTargetBaseLogResponse;

@Repository
@Lazy
public interface StRtTgtBaseLogMapper {

	/**
	 * 메뉴별 사용현황 조회 - 메뉴별 사용현황 Grid count 조회
	 *
	 * @param RtTargetBaseLogRequest
	 * @return
	 * @throws Exception
	 */
	int getMenuUseStatusListCount(RtTargetBaseLogRequest RtTargetBaseLogRequest) throws Exception;

	/**
	 * 메뉴별 사용현황 조회 - 메뉴별 사용현황 Grid 조회
	 *
	 * @param RtTargetBaseLogRequest
	 * @return
	 * @throws Exception
	 */
	List<RtTargetBaseLogResponse> getMenuUseStatusList(RtTargetBaseLogRequest RtTargetBaseLogRequest) throws Exception;

	/**
	 * 메뉴별 사용현황 조회 - 사용자별 메뉴 사용현황 Grid count 조회
	 *
	 * @param RtTargetBaseLogRequest
	 * @return
	 * @throws Exception
	 */
	int getUserMenuUseStatusListCount(RtTargetBaseLogRequest RtTargetBaseLogRequest) throws Exception;

	/**
	 * 메뉴별 사용현황 조회 - 사용자별 메뉴 사용현황 Grid count 조회
	 *
	 * @param RtTargetBaseLogRequest
	 * @return
	 * @throws Exception
	 */
	List<RtTargetBaseLogResponse> getUserMenuUseStatusList(RtTargetBaseLogRequest RtTargetBaseLogRequest)
			throws Exception;

}