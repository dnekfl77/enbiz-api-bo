package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.response.login.PrivacyPolicyInfo;
import com.enbiz.api.bo.app.entity.StIndInfoQryRtInfo;

@Repository
@Lazy
public interface StIndInfoQryRtInfoMapper {

	List<PrivacyPolicyInfo> getStIndInfoQryRtInfoList(String userId);

}
