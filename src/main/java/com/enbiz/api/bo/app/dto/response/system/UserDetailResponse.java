package com.enbiz.api.bo.app.dto.response.system;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.enbiz.api.bo.app.dto.response.login.PrivacyPolicyInfo;
import com.enbiz.api.bo.app.entity.StIndInfoQryRtInfo;
import com.enbiz.api.bo.app.entity.StUserBase;

import lombok.Getter;
import lombok.Setter;

@Alias("UserDetailResponse")
@Getter
@Setter
public class UserDetailResponse {
	private StUserBase userInfo;
	private List<PrivacyPolicyInfo> individualInfoRightList;
}
