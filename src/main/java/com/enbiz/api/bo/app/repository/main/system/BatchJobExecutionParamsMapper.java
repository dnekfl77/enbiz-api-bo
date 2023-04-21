package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.BatchJobExecutionParams;

@Repository
@Lazy
public interface BatchJobExecutionParamsMapper {

	List<BatchJobExecutionParams> getBatchParamList(BatchJobExecutionParams batchJobExecutionParams);

}