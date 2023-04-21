package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StBbTgtInfo;

@Repository
@Lazy
public interface StBbTgtInfoTrxMapper {
	int insertStBbTgtInfo(StBbTgtInfo stBbTgtInfo);

	int deleteStBbTgtInfo(StBbTgtInfo stBbTgtInfo);
}
