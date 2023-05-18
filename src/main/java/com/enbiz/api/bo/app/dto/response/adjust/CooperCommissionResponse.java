package com.enbiz.api.bo.app.dto.response.adjust;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.BaseCommonDto;

import lombok.Getter;
import lombok.Setter;

@Alias("CooperCommissionResponse")
@Getter
@Setter
public class CooperCommissionResponse extends BaseCommonDto {
	private String entrNo;		//제휴사번호
	private String entrNm;		//제휴사명
	private String bmanNo;		//사업자번호
	private String chlTypCd;	//채널유형
	private String chlNm;		//채널명
	private String chlDtlNo;	//상세채널번호
	private String chlDtlNm;	//상세채널명
	private String ordNo;		//주문번호
	private String ordSeq;		//주문순번
	private String saleDtm;		//매출일자
	private String saleGb;		//판매구분
	private String ordQty;		//판매수량
	private String orgSalePrc;	//판매금액
	private String salePrc;		//매출금액
	private String cmsnRtAmt;	//수수료율
	private String cmsnAmt;		//수수료
	private String startDate;	//매출일자 조회조건
	private String endDate;
	private String adjCloseYn;	//매출마감여부조회조건
}