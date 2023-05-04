package com.enbiz.api.bo.app.dto.response.system;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.entity.BaseCommonDto;

import lombok.Getter;
import lombok.Setter;

@Alias("StBatchLogResponse")
@Getter
@Setter
public class StBatchLogResponse extends BaseCommonDto {
	private String jobExecutionId;
	private String createTime;
	private String jobName;
	private String status;
	private String exitMessage;
	private String startTime;
	private String endTime;
}