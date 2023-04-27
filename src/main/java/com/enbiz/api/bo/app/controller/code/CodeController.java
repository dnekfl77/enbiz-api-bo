package com.enbiz.api.bo.app.controller.code;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.code.CodeReqDto;
import com.enbiz.api.bo.app.dto.code.CodeResDto;
import com.enbiz.api.bo.app.dto.request.login.LoginRequest;
import com.enbiz.api.bo.app.entity.StStdCd;
import com.enbiz.api.bo.app.service.code.CodeService;
import com.enbiz.api.bo.base.repository.CodeRepository;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;

@RestController
@Lazy
@RequiredArgsConstructor
@RequestMapping("/common/code")
public class CodeController {
	private final CodeService codeService;
	private final CodeRepository codeRepository;

	@GetMapping("/getStStdCd")
	public Response<Map<String, List<StStdCd>>> getStStdCd( String grpCds) throws Exception {
		return new Response<Map<String, List<StStdCd>>>().setPayload(codeService.getStStdCd(grpCds));
	}

	@GetMapping("/getReverseStStdCd")
	public Response<Map<String, List<StStdCd>>> getReverseStStdCd( String grpCds) throws Exception {
		return new Response<Map<String, List<StStdCd>>>().setPayload(codeService.getReverseStStdCd(grpCds));
	}

	@GetMapping("/getForwardCdCdNmFromStStdCdByArrayGrpCd")
	public Response<Map<String, List<CodeResDto>>> getForwardCdCdNmFromStStdCdByArrayGrpCd( String grpCds)
			throws Exception {
		return new Response<Map<String, List<CodeResDto>>>()
				.setPayload(codeService.getForwardCdCdNmFromStStdCdByArrayGrpCd(grpCds));
	}

	@GetMapping("/getReverseCdCdNmFromStStdCdByArrayGrpCd")
	public Response<Map<String, List<CodeResDto>>> getReverseCdCdNmFromStStdCdByArrayGrpCd( String grpCds)
			throws Exception {
		return new Response<Map<String, List<CodeResDto>>>()
				.setPayload(codeService.getReverseCdCdNmFromStStdCdByArrayGrpCd(grpCds));
	}

	@GetMapping("/getForwardCdCdNmFromCcSiteBaseByEmpty")
	public Response<Map<String, List<CodeResDto>>> getForwardCdCdNmFromCcSiteBaseByEmpty() throws Exception {
		return new Response<Map<String, List<CodeResDto>>>()
				.setPayload(codeService.getForwardCdCdNmFromCcSiteBaseByEmpty());
	}

	@GetMapping("/getForwardCdCdNmFromStStdCdByGrpCdRef1Val")
	public Response<Map<String, List<CodeResDto>>> getForwardCdCdNmFromStStdCdByGrpCdRef1Val(
			 CodeReqDto params) throws Exception {
		return new Response<Map<String, List<CodeResDto>>>()
				.setPayload(codeService.getForwardCdCdNmFromStStdCdByGrpCdRef1Val(params));
	}

	@PostMapping("/getForwardCdCdNmByMixedCode")
    public Response<Map<String, List<CodeResDto>>> getForwardCdCdNmByMixedCode(@RequestBody List<CodeReqDto> params) throws Exception {
    	return new Response<Map<String, List<CodeResDto>>>().setPayload(codeService.getForwardCdCdNmByMixedCode(params));
    }

	@GetMapping("/getButtonByPageRoleList")
	public Response<String> getButtonByPageRoleList( LoginRequest loginRequest) throws Exception {
		String buttonRole = codeRepository.getButtonByPageRoleList(loginRequest);
		return new Response<String>().setPayload(buttonRole);
	}
}
