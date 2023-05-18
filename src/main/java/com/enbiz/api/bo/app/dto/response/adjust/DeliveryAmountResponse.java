package com.enbiz.api.bo.app.dto.response.adjust;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.BaseCommonDto;

import lombok.Getter;
import lombok.Setter;

@Alias("DeliveryAmountResponse")
@Getter
@Setter
public class DeliveryAmountResponse extends BaseCommonDto {
	private String saleYm;		//정산년월
	private String ordNo;		//주문번호
	private String deliTyp;		//배송유형
	private String saleDtm;		//매출일자
	private String brandNm;		//브랜드
	private String yearCnt;		//연차
	private String deliAmt;		//배송비
	private String deliAmtCpn;	//배송비(쿠폰)
	private String deliAmtSum;	//총배송비
	private String deliProcNm;	//배송비부담주체
	private String deliAmtCus;	//고객부담금
	private String deliAmtOur;	//자사부담금
	private String deliAmtEntr;	//업체부담금
	private String deliAmtPg;	//PG
	private String deliAmtMilg;	//한섬마일리지
	private String deliAmtEm;	//e-money
	private String etcDeliAmt;	//수기배송비
	private String etcDeliCaus;	//수기사유
}