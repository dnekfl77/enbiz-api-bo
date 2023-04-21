package com.enbiz.api.bo.app.repository.main.display;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.display.PrSitePopupInfoRequest;
import com.enbiz.api.bo.app.dto.response.display.PrSitePopupChlAplyInfoResponse;

import java.util.List;

@Repository
@Lazy
public interface PrSitePopupChlAplyInfoMapper {

	/**
	 * 팝업 관리 채널적용목록 목록
	 * 
	 * @param prSitePopupInfoRequest
	 * @return
	 */
	List<PrSitePopupChlAplyInfoResponse> getSitePopupChlAplyInfo(PrSitePopupInfoRequest prSitePopupInfoRequest);

	/**
	 * 팝업 관리 채널적용목록 목록 수
	 * 
	 * @param prSitePopupInfoRequest
	 * @return
	 */
	int getSitePopupChlAplyInfoCount(PrSitePopupInfoRequest prSitePopupInfoRequest);
}
