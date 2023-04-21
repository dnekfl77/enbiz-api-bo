package com.enbiz.api.bo.app.dto.response.sample;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Alias("sampleResponse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleResponse {
	private Long id;
	private String name;
	private String description;
}
