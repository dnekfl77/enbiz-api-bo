package com.enbiz.api.bo.app.repository.main.display;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.display.PrConrBaseRequest;
import com.enbiz.api.bo.app.dto.response.display.PrConrTgtInfoResponse;

import java.util.List;

@Repository
@Lazy
public interface PrConrTgtInfoMapper {

	/**
	 * 코너대상정보 조회
	 * 
	 * @param prConrBaseRequest
	 * @return
	 */
	List<PrConrTgtInfoResponse> getCornerTargetInfoList(PrConrBaseRequest prConrBaseRequest);

}
