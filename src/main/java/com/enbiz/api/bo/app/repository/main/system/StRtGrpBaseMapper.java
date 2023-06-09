package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.system.RtGroupBaseRequest;
import com.enbiz.api.bo.app.dto.response.system.RtGroupBaseResponse;

@Repository
@Lazy
public interface StRtGrpBaseMapper {
	/**
	 * 권한 그룹 리스트 조회
	 */
	List<RtGroupBaseResponse> getStRtGrpBaseList(RtGroupBaseRequest RtGroupBaseRequest);

	/**
	 * 권한 그룹 리스트 전체수 조회
	 */
	int getStRtGrpBaseListCount(RtGroupBaseRequest RtGroupBaseRequest);
}
