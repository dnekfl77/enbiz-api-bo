package com.enbiz.api.bo.app.dto.request.adjust;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.Getter;
import lombok.Setter;

@Alias("SalesDetailsRequest")
@Getter
@Setter
public class SalesDetailsRequest extends BaseCommonEntity {
	private String startDate;		//매출일자
	private String endDate;
	private String ordNo;			//주문번호
	private String saleGb;			//판매구분
	private String erpTransYn;		//erp전송여부
	private String adjCloseYn;		//매출마감여부
	private String compareResult;	//대사결과
	private String entrNo;			//협력사
	
	//매출마감
	private String closeDtm;		//마감년월
	private String closeYn;			//마감여부
	private String adtnOcurGbCd;	//부가비용발생구분코드 10:발생, 20:취소
	
	//대사정보수정
	private String ordSeq;			//주문순번
	private String saleGbCd;		//판매구분
	private String dscdCaus;		//불일치사유
	
	//전표데이터 생성/삭제
	private String slipErpTransYn;	//전표erp전송여부
	private String slipGenTyp;		//전표생성유형
}
