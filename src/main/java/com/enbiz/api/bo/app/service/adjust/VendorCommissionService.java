package com.enbiz.api.bo.app.service.adjust;

import java.util.List;

import com.enbiz.api.bo.app.dto.request.adjust.VendorCommissionRequest;
import com.enbiz.api.bo.app.dto.response.adjust.VendorCommissionResponse;

public interface VendorCommissionService {
	/**
	 * 업체매출수수료조회 목록 Count 조회
	 * @param  vendorCommissionRequest
	 * @return 목록 Count
	 * @throws Exception
	 */
	int getVendorCommissionListCount(VendorCommissionRequest vendorCommissionRequest);
	
	/**
	 * 업체매출수수료조회 목록 조회
	 * @param  vendorCommissionRequest
	 * @return 목록
	 * @throws Exception
	 */
	List<VendorCommissionResponse> getVendorCommissionList(VendorCommissionRequest vendorCommissionRequest);
}
