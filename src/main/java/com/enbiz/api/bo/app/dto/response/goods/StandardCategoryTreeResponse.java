package com.enbiz.api.bo.app.dto.response.goods;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ========================== 표준 분류 관리 목록 Response DTO
 * ==========================
 */
@Alias("StandardCategoryTreeResponse")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardCategoryTreeResponse extends BaseCommonEntity {
	private static final long serialVersionUID = 1L;
	private String stdCtgNo;// 표준카테고리번호 varchar(15) Not Null
	private String stdCtgNm;// 표준카테고리명 varchar(200) Not Null
	private String leafCtgYn;// 리프카테고리여부 varchar(1) Not Null
	private String useYn;// 사용여부 varchar(1) Not Null
	private String sortSeq;// 정렬순서 numeric(5) Not Null Default 0
	private String uprStdCtgNo;// 상위표준카테고리번호 varchar(15) Null
	private String stdLrgCtgNo;// 표준대카테고리번호 varchar(15) Null
	private String stdMidCtgNo;// 표준중카테고리번호 varchar(15) Null
	private String stdSmlCtgNo;// 표준소카테고리번호 varchar(15) Null
	private String stdThnCtgNo;// 표준세카테고리번호 varchar(15) Null
	private String mdId;// Md아이디 varchar(10) Null
	private String safeCertiNeedYn;// 안전인증필요여부 varchar(1) Null
	private String goodsNotiLisartCd;// 상품고시품목코드(Pr012) varchar(10) Null
	private String sysRegId;// 시스템등록자id varchar(30) Not Null
	private String sysRegDtm;// 시스템등록일시 timestamp Not Null
	private String sysModId;// 시스템수정자id varchar(30) Not Null
	private String sysModDtm;// 시스템수정일시 timestamp NOT NULL

	private String level; // 레벨
	private String hierarchy; // 계층구조
	private String hierarchyText; // ex) 색조화장품>베이스 메이크업
}
