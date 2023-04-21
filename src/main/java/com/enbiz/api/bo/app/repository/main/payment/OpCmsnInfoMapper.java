package com.enbiz.api.bo.app.repository.main.payment;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.payment.OpCmsnInfoRequest;
import com.enbiz.api.bo.app.dto.response.payment.OpCmsnInfoResponse;
import com.enbiz.api.bo.app.entity.OpCmsnInfo;

@Repository
@Lazy
public interface OpCmsnInfoMapper {

	/**
	 * 결제수수료관리 목록 조회
	 * 
	 * @param opCmsnInfoRequest
	 * @return OpCardBinInfoResponse
	 */
	List<OpCmsnInfoResponse> getClearingCommissionList(OpCmsnInfoRequest opCmsnInfoRequest);

	/**
	 * 결제수수료관리 목록 수
	 * 
	 * @param opCmsnInfoRequest
	 * @return int
	 */
	int getClearingCommissionListCount(OpCmsnInfoRequest opCmsnInfoRequest);

	/**
	 * 결제수수료관리 상세 조회
	 * 
	 * @param opCmsnInfoRequest
	 * @return OpCmsnInfoResponse
	 */
	OpCmsnInfoResponse getClearingCommissionDetail(OpCmsnInfoRequest opCmsnInfoRequest);

	/**
	 * 가맹점 전체 리스트 조회
	 * 
	 * @return OpCmsnInfoResponse
	 */
	List<OpCmsnInfoResponse> getMersTotalList();

	/**
	 * 가맹점 전체 리스트 조회
	 * 
	 * @param opCmsnInfoRequest
	 * @return OpCmsnInfoResponse
	 */
	List<OpCmsnInfoResponse> getMappingMersList(OpCmsnInfoRequest opCmsnInfoRequest);

	/**
	 * 수수료율 적용 개월별 리스트
	 * 
	 * @param opCmsnInfoRequest
	 * @return OpCmsnInfoResponse
	 */
	List<OpCmsnInfoResponse> getMonthList(OpCmsnInfoRequest opCmsnInfoRequest);

	/**
	 * 적용기간 중복 여부 확인
	 * 
	 * @param opCmsnInfoRequest
	 * @return int
	 */
	List<OpCmsnInfoResponse> aplyDateCheck(OpCmsnInfoRequest opCmsnInfoRequest);

	/**
	 * 결제수수료관리 상세 등록
	 * 
	 * @param opCmsnInfo
	 */
	void insertClearingCommissionDetail(OpCmsnInfo opCmsnInfo);

	/**
	 * 결제수수료관리 상세 수정
	 * 
	 * @param opCmsnInfoRequest
	 */
	void updateClearingCommissionDetail(OpCmsnInfoRequest opCmsnInfoRequest);

	/**
	 * 결제수수료관리 상세 삭제
	 * 
	 * @param opCmsnInfo
	 */
	void deleteClearingCommissionDetail(OpCmsnInfo opCmsnInfo);

}
