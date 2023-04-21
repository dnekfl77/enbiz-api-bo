package com.enbiz.api.bo.app.repository.main.delivery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.LoDeliDtl;

@Repository
@Lazy
public interface LoDeliDtlMapper {

	/**
	 * 추가
	 * 
	 * @param loDeliDtl
	 */
	void insertLoDeliDtl(LoDeliDtl loDeliDtl);
}
