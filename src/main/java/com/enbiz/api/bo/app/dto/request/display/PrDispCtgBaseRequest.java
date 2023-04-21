package com.enbiz.api.bo.app.dto.request.display;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ========================== 전시카테고리 조회 팝업 Request Dto
 * ==========================
 */

@Alias("PrDispCtgBaseRequest")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrDispCtgBaseRequest extends BaseCommonEntity {

	// ===============[View Argument]===============//
	/*
	 * @NotNull
	 * 
	 * @NotEmpty
	 */ // 그리드 페이지와 Tree 페이지가 공통으로 참조하여 사용 불가
	private String argSelectType;

	private String argUseYn;
	private String argDispYn;
	private String argSiteNo;
	private String argShopType;

	private String rootNode; // 카테고리 루트노드 상수를 담는 변수

	// ===============[Query Argument]===============//
	private String grpCd; // 공통코드 그룹값
	private String cd; // 공통코드 값
	private String cdNm; // 공통코드 이름
	private String dispYn; // 전시여부
	private String useYn; // 사용여부
	private String dispCtgNo; // 전시카테고리번호
	private String dispCtgNm; // 전시카테고리명
	private String siteNo; // 사이트번호
	private String siteNm; // 사이트명
	private String shopTypCd; // 매장유형코드
	private String lrgCtgNo; // 대카테고리번호
	private String lrgCtgNm; // 대카테고리명
	private String midCtgNo; // 중카테고리번호
	private String midCtgNm; // 중카테고리명
	private String smlCtgNo; // 소카테고리번호
	private String smlCtgNm; // 소카테고리명
	private String thnCtgNo; // 세카테고리번호
	private String thnCtgNm; // 세카테고리명
	private String leafYn; // 최하위 여부
	private String hierarchy; // Tree 계층을 위한 변수
	private String hierarchyNm; // Tree 계층을 위한 변수(text)

	private String dpmlNo; // 몰 정보(몰 번호)
	private String dispSeq; // 전시순서
	private String dispStrDt; // 전시시작일자
	private String dispEndDt; // 전시중료일자

}
