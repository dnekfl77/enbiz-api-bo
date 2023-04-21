package com.enbiz.api.bo.app.dto.request.display;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ========================== 전시카테고리 관리 _ 매장전시상품 Request Dto
 * ==========================
 */

@Alias("PrDispGoodsInfoRequest")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrDispGoodsInfoRequest extends BaseCommonEntity {

	private String dispCtgNo; // 전시카테고리번호
	private String goodsNo; // 상품번호

}
