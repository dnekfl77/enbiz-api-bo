package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StIndInfoQryLog;

@Repository
@Lazy
public interface StIndInfoQryLogMapper {

	void insertStIndInfoQryLog(StIndInfoQryLog stIndInfoQryLog) throws Exception;

}
