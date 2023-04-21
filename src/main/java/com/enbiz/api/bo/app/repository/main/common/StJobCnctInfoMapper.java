package com.enbiz.api.bo.app.repository.main.common;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.common.DashboardAlarmRequest;
import com.enbiz.api.bo.app.dto.request.popup.JobCnctListRequest;
import com.enbiz.api.bo.app.dto.request.popup.JobCnctRequest;
import com.enbiz.api.bo.app.dto.response.common.DashboardAlarmResponse;
import com.enbiz.api.bo.app.dto.response.popup.JobCnctListResponse;
import com.enbiz.api.bo.app.dto.response.popup.JobCnctResponse;
import com.enbiz.api.bo.app.entity.StJobCnctInfo;

@Repository
@Lazy
public interface StJobCnctInfoMapper {

	List<JobCnctListResponse> getJobCnctInfoList(JobCnctListRequest jobCnctListRequest);

	int getJobCnctInfoListCount(JobCnctListRequest jobCnctListRequest);

	void insertJobCnctInfo(StJobCnctInfo stJobCnctInfo);

	JobCnctResponse getJobCnctQuesInfo(JobCnctRequest jobCnctRequest);

	List<DashboardAlarmResponse> getDashboardAlarmList(DashboardAlarmRequest dashboardAlarmRequest);

}
