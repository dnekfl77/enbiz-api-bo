package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StStdCdEx;
import com.enbiz.api.bo.app.entity.StStdCdMl;

@Repository
@Lazy
public interface StStdCdMlTrxMapper {

	void insertUpdateStStdCdMl(StStdCdMl stStdCdMl);

	void deleteStStdCdMl(StStdCdMl stStdCdMl);

	void updateSystemIFMgmtList(StStdCdEx stStdCdEx);

	void updateSystemPayMeanGdMgmtInfo(StStdCdEx stStdCdEx);
}
