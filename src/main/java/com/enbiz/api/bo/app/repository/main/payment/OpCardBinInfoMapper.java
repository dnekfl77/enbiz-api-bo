package com.enbiz.api.bo.app.repository.main.payment;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.payment.OpCardBinInfoRequest;
import com.enbiz.api.bo.app.dto.response.payment.OpCardBinInfoResponse;
import com.enbiz.api.bo.app.entity.OpCardBinInfo;

@Repository
@Lazy
public interface OpCardBinInfoMapper {

	/**
	 * 카드Bin 목록 조회
	 * 
	 * @param opCardBinInfoRequest
	 * @return OpCardBinInfoResponse
	 */
	List<OpCardBinInfoResponse> getCardBinList(OpCardBinInfoRequest opCardBinInfoRequest);

	/**
	 * 카드Bin 목록 수
	 * 
	 * @param opCardBinInfoRequest
	 * @return int
	 */
	int getCardBinListCount(OpCardBinInfoRequest opCardBinInfoRequest);

	/**
	 * 카드Bin 등록
	 */
	void insertOpCardBinInfo(OpCardBinInfo opCardBinInfo);

	/**
	 * 카드Bin 수정
	 */
	void updateOpCardBinInfo(OpCardBinInfo opCardBinInfo);

	/**
	 * 카드Bin 삭제
	 */
	void deleteOpCardBinInfo(OpCardBinInfo opCardBinInfo);

	/**
	 * Bin번호 중복 여부 확인
	 * 
	 * @param opCardBinInfoRequest
	 * @return
	 */
	int checkCardBinno(OpCardBinInfoRequest opCardBinInfoRequest);

}
