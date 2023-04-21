package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StIndInfoQryRtInfo;

@Repository
@Lazy
public interface StIndInfoQryRtInfoTrxMapper {

	void insertStIndInfoQryRtInfo(StIndInfoQryRtInfo stIndInfoQryRtInfo);

	void updateStIndInfoQryRtInfo(StIndInfoQryRtInfo stIndInfoQryRtInfo);

	void saveStIndInfoQryRtInfo(StIndInfoQryRtInfo stIndInfoQryRtInfo);
}
