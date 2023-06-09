package com.enbiz.api.bo.app.dto.response.goods;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.PrRelGoodsInfo;

import lombok.Getter;
import lombok.Setter;

/**
 * 관계상품정보 Response
 */
@Getter
@Setter
@Alias("RelatedGoodsResponse")
public class RelatedGoodsResponse extends PrRelGoodsInfo {

	private String goodsNm; // 상품명
	private String brandNm; // 브랜드명
	private String entrNo; // 협력사번호
	private String entrNm; // 협력사명
	private String mdId; // 담당MD
	private String saleStatCdNm; // 판매상태코드명
	private String dispYn; // 전시여부
	private String deliProcTypCdNm; // 배송처리유형명(PR008)
	private String deliGoodsGbCdNm; // 배송상품구분코드명(PR010)
	private Integer salePrc; // 판매가
	private String dispDlexAmt; // 배송비

}
