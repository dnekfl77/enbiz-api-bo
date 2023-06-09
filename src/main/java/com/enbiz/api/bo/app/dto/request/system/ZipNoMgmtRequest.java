package com.enbiz.api.bo.app.dto.request.system;

import javax.validation.constraints.NotEmpty;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.BaseCommonDto;

import lombok.Getter;
import lombok.Setter;

@Alias("ZipNoMgmtRequest")
@Getter
@Setter
public class ZipNoMgmtRequest extends BaseCommonDto {

	@NotEmpty
	private String ctpNmParam; // 시도명
	@NotEmpty
	private String sigNmParam; // 시구군명
	@NotEmpty
	private String param1; // 검색어
	private String param2; // 검색어2

}
