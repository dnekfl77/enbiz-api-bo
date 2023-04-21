package com.enbiz.api.bo.app.repository.main.customerservice;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.CsCcnOrdGoodsInfo;

/**
 * 고객상담주문상품정보
 */
@Repository
@Lazy
public interface CsCcnOrdGoodsInfoTrxMapper {

	/**
	 * 고객상담주문상품정보 insert
	 */
	void insertCsCcnOrdGoodsInfo(CsCcnOrdGoodsInfo csCcnOrdGoodsInfo) throws Exception;
}
