package com.enbiz.api.bo.app.repository.main.payment;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.payment.OpMersInfoRequest;
import com.enbiz.api.bo.app.dto.response.payment.OpMersInfoResponse;
import com.enbiz.api.bo.app.entity.OpMersInfo;

@Repository
@Lazy
public interface OpMersInfoMapper {

	/**
	 * 가맹점관리 목록 조회
	 * 
	 * @param opMersInfoRequest
	 * @return OpMersInfoResponse
	 */
	List<OpMersInfoResponse> getFranchiseeList(OpMersInfoRequest opMersInfoRequest);

	/**
	 * 가맹점관리 목록 수
	 * 
	 * @param opMersInfoRequest
	 * @return int
	 */
	int getFranchiseeListCount(OpMersInfoRequest opMersInfoRequest);

	/**
	 * 가맹점관리 상세 조회
	 * 
	 * @param opMersInfoRequest
	 * @return OpMersInfoResponse
	 */
	OpMersInfoResponse franchiseeDetailInfo(OpMersInfoRequest opMersInfoRequest);

	/**
	 * 가맹점관리 상세 조회 _ 사이트 리스트
	 * 
	 * @param opMersInfoRequest
	 * @return OpMersInfoResponse
	 */
	List<OpMersInfoResponse> franchiseeSiteList(OpMersInfoRequest opMersInfoRequest);

	/**
	 * 가맹점관리 등록
	 */
	void opMersInfoInsert(OpMersInfo opMersInfo);

	/**
	 * 가맹점관리 수정
	 */
	void opMersInfoUpdate(OpMersInfo opMersInfo);

}
