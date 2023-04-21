package com.enbiz.api.bo.app.dto.request.sample;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.Getter;
import lombok.Setter;

@Alias("sampleRequest")
@Getter
@Setter
public class SampleRequest extends BaseCommonEntity {
	private static final long serialVersionUID = -5756700830219562201L;
	private Long id;
	private String name;
	private String description;
}
