package com.enbiz.api.bo.app.dto.request.adjust;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.Getter;
import lombok.Setter;

@Alias("DeliveryAmountRequest")
@Getter
@Setter
public class DeliveryAmountRequest extends BaseCommonEntity {
	private String startDate;		//매출일자
	private String endDate;
	private String ordNo;			//주문번호
	private String deliTyp;			//배송유형
	private String dlexChrgSubCd;	//배송비부담주체
	private String yearCnt;			//연차
	private String brandNo;			//브랜드
}
