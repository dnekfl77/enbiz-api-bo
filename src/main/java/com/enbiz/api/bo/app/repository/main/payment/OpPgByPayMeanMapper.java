package com.enbiz.api.bo.app.repository.main.payment;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.payment.OpPgByPayMeanRequest;
import com.enbiz.api.bo.app.dto.response.payment.OpPgByPayMeanResponse;
import com.enbiz.api.bo.app.entity.OpPgByPayMean;
import com.enbiz.api.bo.app.entity.StStdCd;

@Repository
@Lazy
public interface OpPgByPayMeanMapper {

	/**
	 * PG사 목록 조회
	 * 
	 * @return
	 */
	List<OpPgByPayMeanResponse> getPgList();

	/**
	 * PG사 목록 수
	 * 
	 * @return int
	 */
	int getPgListCount();

	/**
	 * PG사 업데이트
	 */
	void updateStStdCd(StStdCd stStdCd);

	/**
	 * 결제수단 목록 조회
	 * 
	 * @param opPgByPayMeanRequest
	 * @return
	 */
	List<OpPgByPayMeanResponse> getMethodsOfPaymentList(OpPgByPayMeanRequest opPgByPayMeanRequest);

	/**
	 * 결제수단 목록 수
	 * 
	 * @param opPgByPayMeanRequest
	 * @return int
	 */
	int getMethodsOfPaymentListCount(OpPgByPayMeanRequest opPgByPayMeanRequest);

	/**
	 * 결제수단 입력
	 */
	void insertMethodsOfPaymentList(OpPgByPayMean opPgByPayMean);

	/**
	 * 결제수단 수정
	 */
	void updateMethodsOfPaymentList(OpPgByPayMean opPgByPayMean);
}
