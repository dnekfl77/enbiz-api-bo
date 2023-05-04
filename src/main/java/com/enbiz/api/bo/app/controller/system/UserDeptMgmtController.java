package com.enbiz.api.bo.app.controller.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.dto.request.system.UserDeptRequest;
import com.enbiz.api.bo.app.dto.response.system.UserDeptResponse;
import com.enbiz.api.bo.app.service.code.CodeService;
import com.enbiz.api.bo.app.service.system.UserDeptMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 사용자조직관리 Controller
 */
@RestController
@RequestMapping("/system/userDeptMgmt")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class UserDeptMgmtController{

    private final UserDeptMgmtService userDeptMgmtService;
    private final CodeService codeService;


    /**
     * 부서 계층구조 목록 조회
     * @return 표준 분류 목록
     * @throws Exception
     */
	@GetMapping("/getUserDeptListWithHierarchy")
	Response<List<UserDeptResponse>> getUserDeptListWithHierarchy() throws Exception {
		return new Response<List<UserDeptResponse>>().setPayload(userDeptMgmtService.getUserDeptListWithHierarchy());
	}
	
    /**
     * 부서 목록 수 조회
     */
	@GetMapping("/getUserDeptListCount")
	Response<Integer> getUserDeptListCount(UserDeptRequest userDeptRequest) throws Exception {
		return new Response<Integer>().setPayload(userDeptMgmtService.getUserDeptListCount(userDeptRequest));
	}
	
    /**
     * 부서 목록 조회
     * @param UserDeptRequest
     * @return 하위 표준 분류 목록
     * @throws Exception
     */
	
	@GetMapping("/getUserDeptList")
	Response<List<UserDeptResponse>> getUserDeptList(UserDeptRequest userDeptRequest) throws Exception {
		return new Response<List<UserDeptResponse>>().setPayload(userDeptMgmtService.getUserDeptList(userDeptRequest));
	}

    /**
     * 부서 목록 저장
     * @param realGridCUD 추가, 수정, 삭제 목록
     * @return 성공 메세지
     * @throws Exception
     */
	@PostMapping("/saveUserDeptList")
	Response<String> saveUserDeptList(@RequestBody RealGridCUDRequest<UserDeptRequest> realGridCUD) throws Exception {
		List<UserDeptRequest> createList = realGridCUD.getCreate(), updateList = realGridCUD.getUpdate(), deleteList = realGridCUD.getDelete();
		
		userDeptMgmtService.saveUserDeptList(createList, updateList, deleteList);
		return new Response<String>().setPayload("success");
	}
}
