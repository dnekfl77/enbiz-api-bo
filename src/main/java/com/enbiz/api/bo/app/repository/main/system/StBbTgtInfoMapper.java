package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.response.system.SystemNoticeTargetInfoResponse;
import com.enbiz.api.bo.app.entity.StBbTgtInfo;

@Repository
@Lazy
public interface StBbTgtInfoMapper {
	List<StBbTgtInfo> getStBbTgtInfoList(String bbcNo);

	List<SystemNoticeTargetInfoResponse> getStBbTgtInfoListAddStUserBase(String bbcInfo);
}
