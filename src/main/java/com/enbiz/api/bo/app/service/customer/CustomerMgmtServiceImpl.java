package com.enbiz.api.bo.app.service.customer;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.request.customer.CustomerDetailRequest;
import com.enbiz.api.bo.app.dto.request.customer.CustomerSearchRequest;
import com.enbiz.api.bo.app.dto.request.realgrid.RawRealGridCUDRequest;
import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.dto.response.customer.CustomerDeliveryInfoResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerDetailResponseEx;
import com.enbiz.api.bo.app.dto.response.customer.CustomerGradeHistoryResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerRefundAccountInfoResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerSearchResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerTermsAgreeHistoryResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerTermsAgreeInfoResponse;
import com.enbiz.api.bo.app.entity.EtMbrBase;
import com.enbiz.api.bo.app.entity.EtMbrDlvpInfo;
import com.enbiz.api.bo.app.entity.EtMbrRfdActnInfo;
import com.enbiz.api.bo.app.repository.main.customer.EtMbrBaseMapper;
import com.enbiz.api.bo.app.repository.main.customer.EtMbrBaseTrxMapper;

import lombok.RequiredArgsConstructor;

@Service
@Lazy
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@RequiredArgsConstructor
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	private final EtMbrBaseMapper etMbrBaseMapper;
	private final EtMbrBaseTrxMapper etMbrBaseTrxMapper;

	@Override
	public int getCustomerListCount(CustomerSearchRequest customerSearchRequest) {
		return etMbrBaseMapper.getSearchCustomerByCustomerMgmtViewCount(customerSearchRequest);
	}

	@Override
	public List<CustomerSearchResponse> getCustomerList(CustomerSearchRequest customerSearchRequest) {
		return etMbrBaseMapper.getSearchCustomerByCustomerMgmtViewData(customerSearchRequest);
	}

	@Override
	public CustomerDetailResponseEx getCustomerDetail(CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerDetailByMbrNo(customerDetailRequest);
	}

	@Override
	public List<CustomerDeliveryInfoResponse> getCustomerDeliveryInfoByMbrNoList(
			CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerDeliveryInfoByMbrNoList(customerDetailRequest);
	}

	@Override
	public List<CustomerTermsAgreeInfoResponse> getCustomerTermsAgreeInfoByMbrNoSiteNoList(
			CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerTermsAgreeInfoByMbrNoSiteNoList(customerDetailRequest);
	}

	@Override
	public int getCustomerGradeHistoryByMemberNoCount(CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerGradeHistoryByMbrNoCount(customerDetailRequest);
	}

	@Override
	public List<CustomerGradeHistoryResponse> getCustomerGradeHistoryByMemberNoData(
			CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerGradeHistoryByMemberNoData(customerDetailRequest);
	}

	@Override
	public CustomerRefundAccountInfoResponse getCustomerRefundAccountInfoByMemberNo(
			CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerRefundAccountInfoByMemberNo(customerDetailRequest);
	}

	@Override
	public void saveCustomerRefundAccount(EtMbrRfdActnInfo etMbrRfdActnInfo) throws Exception {
		etMbrBaseTrxMapper.saveCustomerRefundAccount(etMbrRfdActnInfo);
	}

	@Override
	public int getCustomerDeliveryListCount(CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerDeliveryByMbrNoCount(customerDetailRequest);
	}

	@Override
	public List<CustomerDeliveryInfoResponse> getCustomerDeliveryList(CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerDeliveryByMbrNoData(customerDetailRequest);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void saveCustomerDetailAndOthersData(EtMbrBase etMbrBase) throws Exception {
		etMbrBaseTrxMapper.updateEtMbrBaseByCustomerDetail(etMbrBase);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void setOthersDataByMbrNo(RawRealGridCUDRequest rawCudRequest) throws Exception {
		// 배송비정책 그리드
		RealGridCUDRequest<EtMbrDlvpInfo> etMbrDlvpInfo = rawCudRequest.getRequest("customerDeliveryGrid",
				EtMbrDlvpInfo.class);
		List<EtMbrDlvpInfo> createData = etMbrDlvpInfo.getCreate();
		List<EtMbrDlvpInfo> updateData = etMbrDlvpInfo.getUpdate();
		List<EtMbrDlvpInfo> deleteData = etMbrDlvpInfo.getDelete();

		saveEtMbrDlvpInfo(createData, updateData, deleteData);
	}

	private void saveEtMbrDlvpInfo(List<EtMbrDlvpInfo> createData, List<EtMbrDlvpInfo> updateData,
			List<EtMbrDlvpInfo> deleteData) throws Exception {
	}

	@Override
	public int getCustomerTermsAgreeHistoryByMemberNoSiteNoCount(CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerTermsAgreeHistoryByMemberNoSiteNoCount(customerDetailRequest);
	}

	@Override
	public List<CustomerTermsAgreeHistoryResponse> getCustomerTermsAgreeHistoryByMemberNoSiteNoData(
			CustomerDetailRequest customerDetailRequest) {
		return etMbrBaseMapper.getCustomerTermsAgreeHistoryByMemberNoSiteNoData(customerDetailRequest);
	}
}
