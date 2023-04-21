package com.enbiz.api.bo.app.repository.main.vendor;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.EtEntrDlvpInfo;

@Repository
@Lazy
public interface EtEntrDlvpInfoTrxMapper {
	void insertEtEntrDlvpInfoTrx(EtEntrDlvpInfo etEntrDlvpInfo);

	void updateEtEntrDlvpInfoTrx(EtEntrDlvpInfo etEntrDlvpInfo);

	void deleteEtEntrDlvpInfoTrx(EtEntrDlvpInfo etEntrDlvpInfo);
}
