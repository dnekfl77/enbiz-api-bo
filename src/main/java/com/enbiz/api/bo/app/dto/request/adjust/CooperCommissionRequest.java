package com.enbiz.api.bo.app.dto.request.adjust;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.Getter;
import lombok.Setter;

@Alias("CooperCommissionRequest")
@Getter
@Setter
public class CooperCommissionRequest extends BaseCommonEntity {
	private String startDate;		//매출일자
	private String endDate;
	private String entrNo;			//협력사
	private String adjCloseYn;		//매출마감여부
	private String chlTypCd;		//채널유형
	private String chlNm;			//채널명
	
	//제휴사수수료상세목록
	private String detailGrid_chlDtlNo;
	private String detailGrid_startDate;
	private String detailGrid_endDate;
	private String detailGrid_adjCloseYn;
}
