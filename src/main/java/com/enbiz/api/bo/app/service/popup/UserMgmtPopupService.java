package com.enbiz.api.bo.app.service.popup;

import com.enbiz.api.bo.app.dto.request.popup.StUserBaseRequest;
import com.enbiz.api.bo.app.dto.response.popup.StUserBaseResponse;

import java.util.List;

/**
 * 사용자 관리 서비스
 */
public interface UserMgmtPopupService {

    /**
     * 사용자 목록 수 조회
     * @param stUserBaseRequest
     * @return 사용자 목록 수
     * @throws Exception
     */
    int getUserListCount(StUserBaseRequest stUserBaseRequest) throws Exception;

    /**
     * 사용자 목록 조회
     * @param stUserBaseRequest
     * @return 사용자 목록
     * @throws Exception
     */
    List<StUserBaseResponse> getUserList(StUserBaseRequest stUserBaseRequest) throws Exception;

    /**
     * 사용자 목록 조회 (페이징 처리 미포함)
     * @param stUserBaseRequest
     * @return 사용자 목록
     * @throws Exception
     */
    List<StUserBaseResponse> getUserListNoPage(StUserBaseRequest stUserBaseRequest) throws Exception;
}
