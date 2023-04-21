package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.BatchJobExecutionEx;

@Repository
@Lazy
public interface BatchJobExecutionMapper {

	int getBatchLogListCount(BatchJobExecutionEx batchJobExecutionEx);

	List<BatchJobExecutionEx> getBatchLogList(BatchJobExecutionEx batchJobExecutionEx);

}