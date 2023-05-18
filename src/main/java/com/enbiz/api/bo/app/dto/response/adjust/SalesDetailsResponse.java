package com.enbiz.api.bo.app.dto.response.adjust;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.BaseCommonDto;

import lombok.Getter;
import lombok.Setter;

@Alias("SalesDetailsResponse")
@Getter
@Setter
public class SalesDetailsResponse extends BaseCommonDto {
	private String ordNo;			//주문번호
	private String ordSeq;			//주문순번
	private String ordDtm;			//주문일자
	private String saleDtm;			//매출일자
	private String saleGb;			//판매구분
	private String ordQty;			//판매수량
	private String norPrc;			//정상금액
	private String salePrc;			//판매금액
	private String cpnSum;			//쿠폰/합계
	private String cpnGoodsOur;		//쿠폰/상품/자사
	private String cpnGoodsEntr;	//쿠폰/상품/업체
	private String cpnBsketOur;		//쿠폰/장바구니/자사
	private String cpnBsketEntr;	//쿠폰/장바구니/업체
	private String cpnOvlpOur;		//쿠폰/중복/자사
	private String cpnOvlpEntr;		//쿠폰/중복/업체
	private String cpnStafOur;		//쿠폰/임직원/자사
	private String cpnStafEntr;		//쿠폰/임직원/업체
	private String paySum;			//bo/합계
	private String payPg;			//bo/pg
	private String payMilg;			//bo/마일리지
	private String payEm;			//bo/e-money
	private String payHp;			//bo/H.Point
	private String cmsnRate;		//bo/업체수수료율
	private String cmsnPrc;			//bo/업체수수료
	private String entrNm;			//bo/업체
	private String erpSum;			//erp/ERP결제액
	private String erpPg;			//erp/pg결제금액
	private String erpMilg;			//erp/마일리지
	private String erpEm;			//erp/e-money
	private String erpHp;			//erp/H.Point
	private String diffAmt;			//차액
	private String compareResult;	//대사결과
	private String compareResultCd;	//대사결과코드
	private String dscdCaus;		//불일치사유
	private String erpTransYn;		//erp전송여부
	private String adjCloseYn;		//매출마감여부
	private String saleGbCd;		//판매/환입구분
	
	//리스트 합계
	private String sumOrdQty;		//판매수량 합계
	private String sumNorPrc;		//정상금액 합계
	private String sumSalePrc;		//판매금액 합계
	private String sumCpnSum;		//쿠폰/합계 합계
	private String sumCpnGoodsOur;	//쿠폰/상품/자사 합계
	private String sumCpnGoodsEntr;	//쿠폰/상품/업체 합계
	private String sumCpnBsketOur;	//쿠폰/장바구니/자사 합계
	private String sumCpnBsketEntr;	//쿠폰/장바구니/업체 합계
	private String sumCpnOvlpOur;	//쿠폰/중복/자사 합계
	private String sumCpnOvlpEntr;	//쿠폰/중복/업체 합계
	private String sumCpnStafOur;	//쿠폰/임직원/자사 합계
	private String sumCpnStafEntr;	//쿠폰/임직원/업체 합계
	private String sumPaySum;		//bo/합계 합계
	private String sumPayPg;		//bo/pg	합계
	private String sumPayMilg;		//bo/마일리지 합계
	private String sumPayEm;		//bo/emoney 합계
	private String sumPayHp;		//bo/hpoint 합계
	private String sumCmsnPrc;		//bo/업체수수료 합계
	private String sumErpSum;		//erp/합계 합계
	private String sumErpPg;		//erp/pg 합계
	private String sumErpMilg;		//erp/마일리지 합계
	private String sumErpEm;		//erp/emoney 합계
	private String sumErpHp;		//erp/hpoint 합계
	private String sumDiffAmt;		//차액 합계
	
	//매출마감
	private int compareCnt;			//대사결과가 다른 매출 count
	private int erpTransCnt;		//erp전송이 되지않은 매출 count
	private int adjCloseCnt;		//정산마감이 된 매출 count
}