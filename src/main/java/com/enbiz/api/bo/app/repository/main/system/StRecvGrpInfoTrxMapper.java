package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StRecvGrpInfo;

@Repository
@Lazy
public interface StRecvGrpInfoTrxMapper {

	void insertRecvGrp(StRecvGrpInfo stRecvGrpInfo);

	void updateRecvGrp(StRecvGrpInfo stRecvGrpInfo);

	void deleteRecvGrp(StRecvGrpInfo stRecvGrpInfo);

}
