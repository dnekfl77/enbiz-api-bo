package com.enbiz.api.bo.app.repository.main.display;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.PrSitePopupChlAplyInfo;

@Repository
@Lazy
public interface PrSitePopupChlAplyInfoTrxMapper {
	/**
	 * 채널적용정보 등록
	 */
	void insertSitePopupChlAplyInfo(PrSitePopupChlAplyInfo prSitePopupChlAplyInfo);

	/**
	 * 채널적용정보 수정
	 */
	void updateSitePopupChlAplyInfo(PrSitePopupChlAplyInfo prSitePopupChlAplyInfo);

	/**
	 * 채널적용정보 삭제
	 */
	void deleteSitePopupChlAplyInfo(PrSitePopupChlAplyInfo prSitePopupChlAplyInfo);
}
