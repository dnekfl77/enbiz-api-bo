package com.enbiz.api.bo.app.dto.request.delivery;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.BaseCommonDto;

import lombok.Getter;
import lombok.Setter;

@Alias("EtDeliRegnByZipCdRequest")
@Getter
@Setter
public class EtDeliRegnByZipCdRequest extends BaseCommonDto {
	private String deliRegnGbCd;
	private String zipNo;
	private String deliRegnGbNm;
	private String searchWord;
}
