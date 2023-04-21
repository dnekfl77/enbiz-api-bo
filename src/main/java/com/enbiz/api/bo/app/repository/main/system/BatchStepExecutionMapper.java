package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.BatchStepExecution;

@Repository
@Lazy
public interface BatchStepExecutionMapper {

	List<BatchStepExecution> getBatchStepList(BatchStepExecution batchStepExecution);

}