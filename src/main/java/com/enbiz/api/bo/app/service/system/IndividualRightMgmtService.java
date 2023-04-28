package com.enbiz.api.bo.app.service.system;

import java.util.List;

import com.enbiz.api.bo.app.dto.request.system.IndividualRtInfoRequest;
import com.enbiz.api.bo.app.dto.request.system.RtTargetBaseRequest;
import com.enbiz.api.bo.app.dto.response.system.IndividualRtInfoResponse;
import com.enbiz.api.bo.app.dto.response.system.RtTargetBaseResponse;
import com.enbiz.api.bo.app.entity.StIndivRtBaseInfo;
import com.enbiz.api.bo.app.entity.StRtInfo;

public interface IndividualRightMgmtService {
	
	List<IndividualRtInfoResponse> getIndividualRightList(IndividualRtInfoRequest individualRtInfoRequest) throws Exception;
	
	int getIndividualRightListCount(IndividualRtInfoRequest individualRtInfoRequest) throws Exception;
	
	List<RtTargetBaseResponse> getIndividualMenuTreeList(RtTargetBaseRequest rtTargetBaseRequest) throws Exception;

	void registCUD(List<StIndivRtBaseInfo> createList, List<StIndivRtBaseInfo> updateList) throws Exception;
	
	void registIndividualRight(List<StIndivRtBaseInfo> createList) throws Exception;
	
	void updateIndividualRight(List<StIndivRtBaseInfo> updateList) throws Exception;
	
	void updateIndividualButtonRight(List<StRtInfo> updateList) throws Exception;

}