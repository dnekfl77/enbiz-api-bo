package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.response.system.UserMenuRtInfoResponse;
import com.enbiz.api.bo.app.entity.StRtInfo;

@Repository
@Lazy
public interface StRtInfoMapper {

	/**
	 * 사용자 메뉴권한정보 리스트 조회
	 */
	List<UserMenuRtInfoResponse> getUserMenuRtInfoList(String userId);
	   /**
     * stRtInfo 메뉴 존재 여부 체크
     * @param stRtInfo
     * @return
     */
    int getStRtInfo(StRtInfo stRtInfo);
}
