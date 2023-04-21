package com.enbiz.api.bo.app.dto.response.delivery;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.BaseCommonDto;

import lombok.Getter;
import lombok.Setter;

@Alias("EtDeliRegnByZipCdResponse")
@Getter
@Setter
public class EtDeliRegnByZipCdResponse extends BaseCommonDto {
	private String deliRegnGbCd;
	private String zipNo;
	private String baseAddr;
}