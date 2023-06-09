package com.enbiz.api.bo.app.repository.main.delivery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.delivery.EtDeliRegnByZipCdCudRequest;

@Repository
@Lazy
public interface EtDeliRegnByZipCdTrxMapper {
	/**
	 * 배송지역별 우편번호 insert
	 * 
	 * @param EtDeliRegnByZipCdCudRequest
	 * @return
	 */
	void insertDeliRegnByZipCd(EtDeliRegnByZipCdCudRequest etDeliRegnByZipCdCudRequest);

	/**
	 * 배송지역별 우편번호 delete
	 * 
	 * @param EtDeliRegnByZipCdCudRequest
	 * @return
	 */
	void deleteDeliRegnByZipCd(EtDeliRegnByZipCdCudRequest etDeliRegnByZipCdCudRequest);

}
