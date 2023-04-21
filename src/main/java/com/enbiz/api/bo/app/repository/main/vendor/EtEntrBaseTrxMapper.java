package com.enbiz.api.bo.app.repository.main.vendor;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.EtEntrBase;

@Repository
@Lazy
public interface EtEntrBaseTrxMapper {

	void insertEtEntrBaseTrx(EtEntrBase etEntrBase) throws Exception;

	void updateEtEntrBaseTrx(EtEntrBase etEntrBase) throws Exception;
}
