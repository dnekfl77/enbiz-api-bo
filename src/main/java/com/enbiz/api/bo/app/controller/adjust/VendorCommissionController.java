package com.enbiz.api.bo.app.controller.adjust;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.adjust.VendorCommissionRequest;
import com.enbiz.api.bo.app.dto.response.adjust.VendorCommissionResponse;
import com.enbiz.api.bo.app.service.adjust.VendorCommissionService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/adjust/vendorCommission")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class VendorCommissionController {
	private final VendorCommissionService vendorCommissionService;
	
	/**
	 * 업체매출수수료조회 목록 Count 조회
	 * @param  vendorCommissionRequest
	 * @return 목록 Count
	 * @throws Exception
	 */
	@GetMapping("/getVendorCommissionListCount")
	Response<Integer> getVendorCommissionListCount(VendorCommissionRequest vendorCommissionRequest) {
		return new Response<Integer>().setPayload(vendorCommissionService.getVendorCommissionListCount(vendorCommissionRequest));
	}
	
	/**
	 * 업체매출수수료조회 목록 조회
	 * @param vendorCommissionRequest
	 * @return 목록
	 * @throws Exception
	 */
	@GetMapping("/getVendorCommissionList")
	Response<List<VendorCommissionResponse>> getVendorCommissionList(VendorCommissionRequest vendorCommissionRequest) {
		return new Response<List<VendorCommissionResponse>>().setPayload(vendorCommissionService.getVendorCommissionList(vendorCommissionRequest));
	}
}
