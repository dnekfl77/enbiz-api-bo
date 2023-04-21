package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.system.UserRtGroupRequest;
import com.enbiz.api.bo.app.dto.response.system.UserRtGroupResponse;

@Repository
@Lazy
public interface StUserRtGrpMapper {

	/**
	 * 사용자 메뉴권한정보 리스트 조회
	 */
	List<UserRtGroupResponse> getUserRtGrpInfo(UserRtGroupRequest UserRtGroupRequest);

	/**
	 * 사용자 메뉴권한정보 카운팅
	 */
	int getUserRtGrpBtnGridListCount(UserRtGroupRequest UserRtGroupRequest);

}
