package com.enbiz.api.bo.app.dto.response.goods;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ========================== 표준 분류 상품 Response DTO ==========================
 */
@Alias("StandardCategoryGoodsResponse")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardCategoryGoodsResponse extends BaseCommonEntity {

	private String goodsNo; // 표준카테고리 상품번호
	private String goodsNm; // 표준카테고리 상품명
	private String saleStatCdNm; // 표준카테고리 상품 판매상태

}
