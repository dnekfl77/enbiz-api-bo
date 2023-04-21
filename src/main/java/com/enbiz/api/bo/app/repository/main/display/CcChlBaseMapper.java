package com.enbiz.api.bo.app.repository.main.display;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.popup.CcChlBaseRequest;
import com.enbiz.api.bo.app.dto.response.popup.CcChlBaseResponse;
import com.enbiz.api.bo.app.entity.CcChlBase;
import com.enbiz.api.bo.app.entity.CcChlDtlInfo;

@Repository
@Lazy
public interface CcChlBaseMapper {

	/**
	 * 채널 목록
	 * 
	 * @param ccChlBaseRequest
	 * @return
	 */
	List<CcChlBaseResponse> getChannelList(CcChlBaseRequest ccChlBaseRequest);

	/**
	 * 채널 목록 수
	 * 
	 * @param ccChlBaseRequest
	 * @return
	 */
	int getChannelListCount(CcChlBaseRequest ccChlBaseRequest);

	int getCcChlBaseByEntrNoCount(String entrNo);

	List<CcChlBase> getCcChlBaseByEntrNoList(String entrNo);

	void insertCcChlBase(CcChlBase ccChlBase);

	void updateCcChlBase(CcChlBase ccChlBase);

	void deleteCcChlBase(CcChlBase ccChlBase);

	int getCcChlDtlInfoByChlNoCount(String chlNo);

	List<CcChlDtlInfo> getCcChlDtlInfoByChlNoList(String chlNo);

	void insertCcChlDtlInfo(CcChlDtlInfo ccChlDtlInfo);

	void updateCcChlDtlInfo(CcChlDtlInfo ccChlDtlInfo);

	void deleteCcChlDtlInfo(CcChlDtlInfo ccChlDtlInfo);
}
