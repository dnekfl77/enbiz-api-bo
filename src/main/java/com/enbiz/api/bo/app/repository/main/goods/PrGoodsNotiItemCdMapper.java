package com.enbiz.api.bo.app.repository.main.goods;

import java.util.List;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.PrGoodsNotiItemCd;

/**
 * 상품고시항목코드 DAO
 */
@Repository
@Lazy
public interface PrGoodsNotiItemCdMapper {

	/**
	 * 상품고시항목코드목록 조회
	 * 
	 * @param goodsNotiLisartCd
	 * @return
	 */
	List<PrGoodsNotiItemCd> getGoodsNotiItemCdList(String goodsNotiLisartCd);
}
