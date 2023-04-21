package com.enbiz.api.bo.app.repository.main.payment;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.payment.OpPayMeanCtrlInfoRequest;
import com.enbiz.api.bo.app.dto.response.payment.OpPayMeanCtrlInfoResponse;
import com.enbiz.api.bo.app.entity.OpPayMeanCtrlInfo;

@Repository
@Lazy
public interface OpPayMeanCtrlInfoMapper {

	/**
	 * 결제수단 제어 목록 조회
	 * 
	 * @return
	 */
	List<OpPayMeanCtrlInfoResponse> getMethodsOfPaymentControlList(OpPayMeanCtrlInfoRequest opPayMeanCtrlInfoRequest);

	/**
	 * 결제수단 제어 목록 수
	 * 
	 * @return int
	 */
	int getMethodsOfPaymentControlListCount(OpPayMeanCtrlInfoRequest opPayMeanCtrlInfoRequest);

	/**
	 * 결제수단 제어관리 정보, 안내공지 조회
	 * 
	 * @return
	 */
	OpPayMeanCtrlInfoResponse methodsOfPaymentControlDetailInfo(OpPayMeanCtrlInfoRequest opPayMeanCtrlInfoRequest);

	/**
	 * 결제수단 제어관리 저장 _ 등록
	 * 
	 * @return int
	 */
	void opPayMeanCtrlInfoInsert(OpPayMeanCtrlInfo opPayMeanCtrlInfo);

	/**
	 * 결제수단 제어관리 저장 _ 수정
	 * 
	 * @return int
	 */
	void opPayMeanCtrlInfoUpdate(OpPayMeanCtrlInfo opPayMeanCtrlInfo);

}
