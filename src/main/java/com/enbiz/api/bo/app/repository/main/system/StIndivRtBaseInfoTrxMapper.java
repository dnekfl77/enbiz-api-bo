package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.*;

@Repository
@Lazy
public interface StIndivRtBaseInfoTrxMapper {
	void saveStIndivRtBaseInfo(StIndivRtBaseInfo stIndivRtBaseInfo);
	
	void updateStIndivRtBaseInfo(StIndivRtBaseInfo stIndivRtBaseInfo);
}