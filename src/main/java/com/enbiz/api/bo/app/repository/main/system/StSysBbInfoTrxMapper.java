package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StSysBbInfo;

@Repository
@Lazy
public interface StSysBbInfoTrxMapper {

	int insertStSysBbInfo(StSysBbInfo stSysBbInfo);

	int updateStSysBbInfo(StSysBbInfo stSysBbInfo);

	int updateStSysBbInfoQryCnt(String bbcNo);
}
