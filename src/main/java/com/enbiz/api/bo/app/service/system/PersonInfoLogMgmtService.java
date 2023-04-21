package com.enbiz.api.bo.app.service.system;

import com.enbiz.api.bo.app.entity.StIndInfoQryLog;

/**
 * PersonInfoMgmtService
 */
public interface PersonInfoLogMgmtService {

	/**
	 * 개인정보조회로그 신규 등록
	 */
	void insertStIndInfoQryLog(StIndInfoQryLog stIndInfoQryLog) throws Exception;
}
