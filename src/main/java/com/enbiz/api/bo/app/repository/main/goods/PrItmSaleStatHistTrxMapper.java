package com.enbiz.api.bo.app.repository.main.goods;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.PrItmSaleStatHist;

/**
 * 상품단품판매상태이력 Trx DAO
 */
@Repository
@Lazy
public interface PrItmSaleStatHistTrxMapper {

	/**
	 * 일반상품 상세 > 단품판매상태이력 update
	 * 
	 * @param prItmSaleStatHist
	 */
	void updatePrItmSaleStatHist(PrItmSaleStatHist prItmSaleStatHist);

	/**
	 * 일반상품 상세 > 단품판매상태이력 insert
	 * 
	 * @param prItmSaleStatHist
	 */
	void insertPrItmSaleStatHist(PrItmSaleStatHist prItmSaleStatHist);

	/**
	 * 상품승인관리 > 임시 일반상품 단품판매상태이력 승인처리
	 * 
	 * @param prItmSaleStatHist
	 */
	void applyPrItmSaleStatHist(PrItmSaleStatHist prItmSaleStatHist);

}
