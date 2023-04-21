package com.enbiz.api.bo.app.entity;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 표준카테고리 전시 정보
 */
@Alias("PrStdCtgDispInfo")
@Getter
@Setter
public class PrStdCtgDispInfo extends BaseCommonEntity {

	private String stdCtgNo; // 표준카테고리번호
	private String dispCtgNo; // 전시카테고리번호
	private String repCtgYn; // 대표카테고리여부
	private String useYn; // 사용여부

}
