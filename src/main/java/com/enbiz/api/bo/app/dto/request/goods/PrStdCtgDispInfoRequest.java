package com.enbiz.api.bo.app.dto.request.goods;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * ========================== 표준 분류 관리 Request DTO ==========================
 */
@Getter
@Setter
@Alias("PrStdCtgDispInfoRequest")
public class PrStdCtgDispInfoRequest extends BaseCommonEntity {
	private static final long serialVersionUID = 1L;
	private String stdCtgNo; // 표준카테고리번호 varchar(15) Not Null
	private String dispCtgNo; // 전시카테고리번호 varchar(15) Not Null
	private String repCtgYn; // 대표카테고리여부 varchar(1) Not Null
	private String useYn; // 사용여부 varchar(1) Not Null
	private String sysRegId; // 시스템등록자id varchar(30) Not Null
	private String sysRegDtm; // 시스템등록일시 timestamp Not Null
	private String sysModId; // 시스템수정자id varchar(30) Not Null
	private String sysModDtm; // 시스템수정일시 timestamp NOT NULL
}
