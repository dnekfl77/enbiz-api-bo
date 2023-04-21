package com.enbiz.api.bo.app.repository.main.vendor;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.vendor.CooperateEmployeeSearchRequest;
import com.enbiz.api.bo.app.dto.response.vendor.CooperateEmployeeSearchResponse;

@Repository
@Lazy
public interface EtEntrAempInfoMapper {

	List<CooperateEmployeeSearchResponse> getEtEntrAempInfoList(String entrNo);

	int getCooperateEmployeeSearchListCount(CooperateEmployeeSearchRequest cooperateEmployeeSearchRequest)
			throws Exception;

	List<CooperateEmployeeSearchResponse> getCooperateEmployeeSearchList(
			CooperateEmployeeSearchRequest cooperateEmployeeSearchRequest) throws Exception;

}
