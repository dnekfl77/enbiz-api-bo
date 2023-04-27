package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StRtInfo;
import com.enbiz.api.bo.app.entity.StRtGrpBase;

@Repository
@Lazy
public interface StRtInfoTrxMapper {

    /**
     * 권한 관리 메뉴화면 insert update
     *
     * @param stRtInfo
     * @return
     * @throws Exception
     */
    void saveStRtInfo(StRtInfo stRtInfo);
    
    /**
     * 권한그룹 insert시 권한정보 insert
     */
    void saveStRtInfoSelect(StRtGrpBase stRtGrpBase);

    /**
     * 권한정보 삭제
     */
    void deleteStRtInfo(StRtInfo stRtInfo);
    
    /**
     * 권한정보 사용여부 수정
     */
    void modifyStRtInfoUseYn(StRtInfo stRtInfo);
    
    /**
     * 개별권한관리 메뉴권한 insert
     */
    void saveStRtInfoIndiv(StRtInfo stRtInfo);

}
