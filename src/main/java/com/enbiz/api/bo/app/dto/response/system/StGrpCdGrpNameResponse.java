package com.enbiz.api.bo.app.dto.response.system;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.BaseCommonDto;

import lombok.Getter;
import lombok.Setter;

@Alias("StGrpCdGrpNameResponse")
@Getter
@Setter
public class StGrpCdGrpNameResponse extends BaseCommonDto {
	private String cd;
	private Integer count;
}
