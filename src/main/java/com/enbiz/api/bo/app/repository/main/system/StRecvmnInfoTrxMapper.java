package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StRecvmnInfo;

@Repository
@Lazy
public interface StRecvmnInfoTrxMapper {

	void insertRecvmn(StRecvmnInfo stRecvmnInfo);

	void deleteRecvmn(StRecvmnInfo stRecvmnInfo);

}
