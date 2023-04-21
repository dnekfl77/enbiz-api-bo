package com.enbiz.api.bo.app.repository.main.display;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.PrSitePopupTgtScrn;

@Repository
@Lazy
public interface PrSitePopupTgtScrnTrxMapper {

	/**
	 * 팝업 대상화면 등록
	 * 
	 * @return
	 */
	void prSitePopupTgtScrnInsert(PrSitePopupTgtScrn prSitePopupTgtScrn);

}
