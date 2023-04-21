package com.enbiz.api.bo.app.repository.main.customer;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.customer.WatchCustomerRequest;
import com.enbiz.api.bo.app.entity.EtMbrBase;
import com.enbiz.api.bo.app.entity.EtMbrDlvpInfo;
import com.enbiz.api.bo.app.entity.EtMbrRfdActnInfo;
import com.enbiz.api.bo.app.entity.EtMgrMbrInfo;

@Repository
@Lazy
public interface EtMbrBaseTrxMapper {

	void updateEtMbrBaseByCustomerDetail(EtMbrBase etMbrBase);

	void insertEtMbrDlvpInfo(EtMbrDlvpInfo currentData);

	void updateEtMbrDlvpInfo(EtMbrDlvpInfo currentData);

	void deleteEtMbrDlvpInfo(EtMbrDlvpInfo currentData);

	void saveWatchCustomer(EtMgrMbrInfo etMgrMbrInfo);

	void saveCustomerRefundAccount(EtMbrRfdActnInfo etMbrRfdActnInfo);

	void unlockWatchCustomer(WatchCustomerRequest watchCustomerRequest);
}
