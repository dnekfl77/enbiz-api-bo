package com.enbiz.api.bo.app.controller.popup;

import com.enbiz.api.bo.app.dto.request.popup.StUserBaseRequest;
import com.enbiz.api.bo.app.dto.response.popup.StUserBaseResponse;
import com.enbiz.api.bo.app.service.popup.UserMgmtPopupService;
import com.enbiz.common.base.rest.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 사용자 관리
 */
@RestController
@RequestMapping("/popup/userMgmtPopup")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class UserMgmtPopupController {

    private final UserMgmtPopupService userMgmtPopupService;

    /**
     * 사용자 목록 수 조회
     * @param stUserBaseRequest
     * @return 사용자 목록 수 조회
     * @throws Exception
     */
    @GetMapping("/getUserListCount")
    public Response<Integer> getUserListCount(StUserBaseRequest stUserBaseRequest) throws Exception {
        return new Response<Integer>().setPayload(userMgmtPopupService.getUserListCount(stUserBaseRequest));
    }

    /**
     * 사용자 목록 조회
     * @param stUserBaseRequest
     * @return 사용자 목록 조회
     * @throws Exception
     */
    @GetMapping("/getUserList")
    public Response<List<StUserBaseResponse>> getUserList(StUserBaseRequest stUserBaseRequest) throws Exception {
        return new Response<List<StUserBaseResponse>>().setPayload(userMgmtPopupService.getUserList(stUserBaseRequest));
    }

    /**
     * 사용자 목록 조회 (페이징 처리 미포함)
     * @return 사용자 목록
     * @throws Exception
     */
    @GetMapping("/getUserListNoPage")
    public Response<List<StUserBaseResponse>> getUserListNoPage(StUserBaseRequest stUserBaseRequest) throws Exception {
        return new Response<List<StUserBaseResponse>>().setPayload(userMgmtPopupService.getUserListNoPage(stUserBaseRequest));
    }

}
