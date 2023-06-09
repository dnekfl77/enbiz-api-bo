package com.enbiz.api.bo.app.dto.request.system;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.BaseCommonDto;

import lombok.Getter;
import lombok.Setter;

@Alias("RtTargetBaseRequest")
@Getter
@Setter
public class RtTargetBaseRequest extends BaseCommonDto {

	private String sysGbCd;
	private String rtTgtSeq;
	private String uprRtTgtSeq;

}
