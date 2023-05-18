package com.enbiz.api.bo.app.service.adjust;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.request.adjust.VendorCommissionRequest;
import com.enbiz.api.bo.app.dto.response.adjust.VendorCommissionResponse;
import com.enbiz.api.bo.app.repository.main.adjust.AcOpOrdDtlMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Lazy
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class VendorCommissionServiceImpl implements VendorCommissionService {
	private final AcOpOrdDtlMapper acOpOrdDtlMapper;
	
	/**
	 * 업체매출수수료조회 목록 Count 조회
	 * @param  vendorCommissionRequest
	 * @return 목록 Count
	 * @throws Exception
	 */
	@Override
	public int getVendorCommissionListCount(VendorCommissionRequest vendorCommissionRequest) {
		return acOpOrdDtlMapper.getVendorCommissionListCount(vendorCommissionRequest);
	}
	
	/**
	 * 업체매출수수료조회 목록 조회
	 * @param  vendorCommissionRequest
	 * @return 목록
	 * @throws Exception
	 */
	@Override
	public List<VendorCommissionResponse> getVendorCommissionList(VendorCommissionRequest vendorCommissionRequest) {
		return acOpOrdDtlMapper.getVendorCommissionList(vendorCommissionRequest);
	}
}
