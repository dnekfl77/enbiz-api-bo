package com.enbiz.api.bo.app.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.dto.request.system.RtTargetBaseCudRequest;
import com.enbiz.api.bo.app.dto.request.system.RtTargetBaseRequest;
import com.enbiz.api.bo.app.dto.response.system.RtTargetBaseResponse;
import com.enbiz.api.bo.app.entity.StRtTgtBase;
import com.enbiz.api.bo.app.service.system.MenuMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/system/menuMgmt")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class MenuMgmtController {
	private final MenuMgmtService menuMgmtService;
	
    /**
    * 메뉴 트리 리스트 조회
    * @param RtTargetBaseRequest
    * @return
    *
    */
    @GetMapping("/getMenuMgmtTreeList")
    public Response<List<RtTargetBaseResponse>> getMenuMgmtTreeList(RtTargetBaseRequest RtTargetBaseRequest) throws Exception {
    	return new Response<List<RtTargetBaseResponse>>().setPayload(menuMgmtService.getMenuMgmtTreeList(RtTargetBaseRequest));
    }

    /**
     * 메뉴 트리 클릭시 메뉴상세정보 조회
     * @param  RtTargetBaseRequest
     * @return List<RtTargetBaseResponse>
     * @throws Exception
     */
    @GetMapping("/getMenuInfo")
    public Response<RtTargetBaseResponse> getMenuInfo(RtTargetBaseRequest RtTargetBaseRequest) throws Exception {
        return new Response<RtTargetBaseResponse>().setPayload(menuMgmtService.getMenuInfo(RtTargetBaseRequest));
    }
    
    /**
     * 메뉴 트리 클릭시 하위메뉴리스트 조회(건수)
     * @param  RtTargetBaseRequest
     * @return List<RtTargetBaseResponse>
     * @throws Exception
     */
    @GetMapping("/getSubMenuListCount")
    public Response<Integer> getSubMenuListCount(RtTargetBaseRequest RtTargetBaseRequest) throws Exception {
        return new Response<Integer>().setPayload(menuMgmtService.getSubMenuListCount(RtTargetBaseRequest));
    }
    
    /**
     * 메뉴 트리 클릭시 하위메뉴리스트 조회
     * @param  RtTargetBaseRequest
     * @return List<RtTargetBaseResponse>
     * @throws Exception
     */
    @GetMapping("/getSubMenuList")
    public Response<List<RtTargetBaseResponse>> getSubMenuList(RtTargetBaseRequest RtTargetBaseRequest) throws Exception {
        return new Response<List<RtTargetBaseResponse>>().setPayload(menuMgmtService.getSubMenuList(RtTargetBaseRequest));
    }

    /**
     * 메뉴상세정보 등록/수정 수정 및 저장
     * @param
     * @return 성공 메시지
     * @throws Exception
     */
    @PostMapping("/modifyMenuInfo")
    public Response<String> modifyMenuInfo(@RequestBody RtTargetBaseCudRequest RtTargetBaseCudRequest) throws Exception {
        menuMgmtService.modifyMenuInfo(RtTargetBaseCudRequest);
        return new Response<String>().setPayload("success");
    }
    @PostMapping("/registMenuInfo")
    public Response<String> registMenuInfo(@RequestBody RtTargetBaseCudRequest RtTargetBaseCudRequest) throws Exception {
        menuMgmtService.registMenuInfo(RtTargetBaseCudRequest);
        return new Response<String>().setPayload("success");
    }
    
    /**
     * 하위 메뉴 저장
     * @param realGridCUD 신규, 수정, 삭제목록
     * @return 성공 메시지
     * @throws Exception
     */
    @PostMapping("/saveSubMenu")
    public Response<String> saveSubMenu(@RequestBody RealGridCUDRequest<StRtTgtBase> realGridCUD) throws Exception {
    	List<StRtTgtBase> createList = realGridCUD.getCreate(), updateList = realGridCUD.getUpdate(), deleteList = realGridCUD.getDelete();
        menuMgmtService.saveSubMenu(createList, updateList, deleteList);
        return new Response<String>().setPayload("success");
    }
    
    /**
     * 메뉴 삭제 시 하위 메뉴가 없는지, 권한이 없지 확인
     * @param RtTargetBaseRequest
     * @return
     * @throws Exception
     */
    @GetMapping("/getSubMenuCheck")
    public Response<Integer> getSubMenuCheck(RtTargetBaseRequest RtTargetBaseRequest) throws Exception {
        return new Response<Integer>().setPayload(menuMgmtService.getSubMenuCheck(RtTargetBaseRequest));
    }
    
    @GetMapping("/getRtInfoCheck")
    public Response<Integer> getRtInfoCheck(RtTargetBaseRequest RtTargetBaseRequest) throws Exception {
        return new Response<Integer>().setPayload(menuMgmtService.getRtInfoCheck(RtTargetBaseRequest));
    }
    
    /**
     * 메뉴 사용여부 수정
     * @param Map
     * @return 성공 메시지
     * @throws Exception
     */
    @PostMapping("/modifyMenuRight")
    public Response<String> modifyMenuRight(@RequestBody Map<String, Object> list) throws Exception {
        menuMgmtService.modifyMenuRight(list);
        return new Response<String>().setPayload("success");
    }
    
    /**
     * 개별권한 메뉴 저장
     * @param Map
     * @return 성공 메시지
     * @throws Exception
     */
    @PostMapping("/saveMenuRightIndiv")
    public Response<String> saveMenuRightIndiv(@RequestBody Map<String, Object> list) throws Exception {
    	menuMgmtService.saveMenuRightIndiv(list);
    	return new Response<String>().setPayload("success");
    }
}
