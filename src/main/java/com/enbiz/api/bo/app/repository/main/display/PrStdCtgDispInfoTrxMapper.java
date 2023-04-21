package com.enbiz.api.bo.app.repository.main.display;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.goods.PrStdCtgDispInfoRequest;
import com.enbiz.api.bo.app.entity.PrStdCtgDispInfo;

import java.util.List;

/**
 * 표준카테고리 전시정보 Trx DAO
 */
@Repository
@Lazy
public interface PrStdCtgDispInfoTrxMapper {

	/**
	 * 연결 소전시 카테고리 목록 등록
	 * 
	 * @param prStdCtgDispInfoRequest
	 */
	void insertPrStdCtgDispInfo(List<PrStdCtgDispInfoRequest> prStdCtgDispInfoRequest);

	/**
	 * 연결 소전시 카테고리 목록 수정
	 * 
	 * @param prStdCtgDispInfoRequest
	 */
	void updatePrStdCtgDispInfo(List<PrStdCtgDispInfoRequest> prStdCtgDispInfoRequest);

	/**
	 * 연결 소전시 카테고리 목록 삭제
	 * 
	 * @param prStdCtgDispInfoRequest
	 */
	void deletePrStdCtgDispInfo(List<PrStdCtgDispInfoRequest> prStdCtgDispInfoRequest);

	/**
	 * 임시 일반상품 등록/상세, 일반상품 상세 > 표준카테고리전시정보 등록
	 * 
	 * @param prStdCtgDispInfo
	 */
	void insertPrStdCtgDispInfoFromGoods(PrStdCtgDispInfo prStdCtgDispInfo);

	/**
	 * 임시 일반상품 등록/상세, 일반상품 상세 > 표준카테고리전시정보 수정
	 * 
	 * @param prStdCtgDispInfo
	 */
	void updatePrStdCtgDispInfoFromGoods(PrStdCtgDispInfo prStdCtgDispInfo);

	/**
	 * 임시 일반상품 등록/상세, 일반상품 상세 > 표준카테고리전시정보 삭제
	 * 
	 * @param prStdCtgDispInfo
	 */
	void deletePrStdCtgDispInfoFromGoods(PrStdCtgDispInfo prStdCtgDispInfo);

}