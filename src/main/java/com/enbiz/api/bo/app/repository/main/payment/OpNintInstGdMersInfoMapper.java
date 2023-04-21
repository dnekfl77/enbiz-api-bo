package com.enbiz.api.bo.app.repository.main.payment;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.OpNintInstGdBase;
import com.enbiz.api.bo.app.entity.OpNintInstGdMersInfo;

@Repository
@Lazy
public interface OpNintInstGdMersInfoMapper {

	/**
	 * 무이자할부안내가맹점정보 등록
	 * 
	 * @param opNintInstGdMersInfo
	 */
	void insertOpNintInstGdMersInfo(OpNintInstGdMersInfo opNintInstGdMersInfo);

	/**
	 * 무이자할부안내가맹점정보 삭제
	 * 
	 * @param opNintInstGdBase
	 */
	void deleteOpNintInstGdMersInfo(OpNintInstGdBase opNintInstGdBase);

}
