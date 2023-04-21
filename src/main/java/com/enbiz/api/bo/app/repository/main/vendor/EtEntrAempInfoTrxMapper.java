package com.enbiz.api.bo.app.repository.main.vendor;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.EtEntrAempInfo;

@Repository
@Lazy
public interface EtEntrAempInfoTrxMapper {
	void insertEtEntrAempInfoTrx(EtEntrAempInfo etEntrAempInfo);

	void updateEtEntrAempInfoTrx(EtEntrAempInfo etEntrAempInfo);

	void deleteEtEntrAempInfoTrx(EtEntrAempInfo etEntrAempInfo);
}
