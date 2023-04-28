package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.system.IndividualRtInfoRequest;
import com.enbiz.api.bo.app.dto.response.system.IndividualRtInfoResponse;
import com.enbiz.api.bo.app.dto.response.system.UserMenuRtInfoResponse;

@Repository
@Lazy
public interface StIndivRtBaseInfoMapper {

    /**
     * 사용자 메뉴권한정보 리스트 조회
     * */
    List<UserMenuRtInfoResponse> getUserMenuRtInfoList(String userId);
    
    /*
     * 개별권한관리 개별 권한 리스트 조회
     */
    List<IndividualRtInfoResponse> getIndividualRightList(IndividualRtInfoRequest individualRtInfoRequest);
    
    /*
     * 개별권한관리 개별 권한 리스트 count
     */
    int getIndividualRightListCount(IndividualRtInfoRequest individualRtInfoRequest);
    
    /*
     * 사용자의 개별권한 유무 체크 (사용자 한명당 개별권한 한개)
     */
    int getIndividualRightCountForCheck(String userId);

}
