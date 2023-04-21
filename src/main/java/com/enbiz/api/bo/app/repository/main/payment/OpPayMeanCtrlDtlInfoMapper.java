package com.enbiz.api.bo.app.repository.main.payment;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.payment.OpPayMeanCtrlInfoRequest;
import com.enbiz.api.bo.app.dto.response.payment.OpPayMeanCtrlInfoResponse;
import com.enbiz.api.bo.app.entity.OpPayMeanCtrlDtlInfo;

@Repository
@Lazy
public interface OpPayMeanCtrlDtlInfoMapper {

	/**
	 * 제어 상세 목록 조회
	 * 
	 * @return
	 */
	List<OpPayMeanCtrlInfoResponse> getMethodsOfPaymentControlDetail(OpPayMeanCtrlInfoRequest opPayMeanCtrlInfoRequest);

	/**
	 * 제어 상세 목록 조회 수
	 * 
	 * @return int
	 */
	int getMethodsOfPaymentControlDetailCount(OpPayMeanCtrlInfoRequest opPayMeanCtrlInfoRequest);

	/**
	 * 결제수단 제어관리 팝업 그리드 저장 _ 등록
	 * 
	 * @param opPayMeanCtrlDtlInfo
	 */
	void insertOpPayMeanCtrlDtlInfo(OpPayMeanCtrlDtlInfo opPayMeanCtrlDtlInfo);

	/**
	 * 결제수단 제어관리 팝업 그리드 저장 _ 삭제
	 * 
	 * @param opPayMeanCtrlDtlInfo
	 */
	void deleteOpPayMeanCtrlDtlInfo(OpPayMeanCtrlDtlInfo opPayMeanCtrlDtlInfo);

}
