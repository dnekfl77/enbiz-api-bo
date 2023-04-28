package com.enbiz.api.bo.app.dto.request.system;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.Getter;
import lombok.Setter;

@Alias("IndividualRtInfoRequest")
@Getter
@Setter
public class IndividualRtInfoRequest extends BaseCommonEntity {
    private String userId; //사용자ID
    private	String rtGrpNm;	//권한그룹명
}
