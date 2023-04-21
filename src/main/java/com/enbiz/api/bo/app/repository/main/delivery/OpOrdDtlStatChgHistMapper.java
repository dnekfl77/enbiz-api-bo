package com.enbiz.api.bo.app.repository.main.delivery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.OpOrdDtlStatChgHist;

@Repository
@Lazy
public interface OpOrdDtlStatChgHistMapper {

	/**
	 * 변경이력 추가
	 * 
	 * @param opOrdDtlStatChgHist
	 */
	void insertOpOrdDtlStatChgHist(OpOrdDtlStatChgHist opOrdDtlStatChgHist);
}
