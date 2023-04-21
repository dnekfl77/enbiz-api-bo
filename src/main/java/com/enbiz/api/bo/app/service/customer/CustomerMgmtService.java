package com.enbiz.api.bo.app.service.customer;

import java.util.List;

import com.enbiz.api.bo.app.dto.request.customer.CustomerDetailRequest;
import com.enbiz.api.bo.app.dto.request.customer.CustomerSearchRequest;
import com.enbiz.api.bo.app.dto.request.realgrid.RawRealGridCUDRequest;
import com.enbiz.api.bo.app.dto.response.customer.CustomerDeliveryInfoResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerDetailResponseEx;
import com.enbiz.api.bo.app.dto.response.customer.CustomerGradeHistoryResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerRefundAccountInfoResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerSearchResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerTermsAgreeHistoryResponse;
import com.enbiz.api.bo.app.dto.response.customer.CustomerTermsAgreeInfoResponse;
import com.enbiz.api.bo.app.entity.EtMbrBase;
import com.enbiz.api.bo.app.entity.EtMbrRfdActnInfo;

public interface CustomerMgmtService {
	/**
	 * 회원 목록 수 조회
	 * 
	 * @param CustomerSearchRequest
	 * @return 회원 목록 수 - Integer
	 * @throws Exception
	 */
	int getCustomerListCount(CustomerSearchRequest customerSearchRequest);

	/**
	 * 회원 목록 조회
	 * 
	 * @param CustomerSearchRequest
	 * @return 회원 목록 - List<CustomerSearchResponse>
	 * @throws Exception
	 */
	List<CustomerSearchResponse> getCustomerList(CustomerSearchRequest customerSearchRequest);

	/**
	 * 회원 상세 뷰 - getData
	 * 
	 * @param customerDetailRequest
	 * @return CustomerDetailResponseEx
	 * @throws Exception
	 */
	CustomerDetailResponseEx getCustomerDetail(CustomerDetailRequest customerDetailRequest);

	/**
	 * 회원 상세 뷰 - getMbrNoList
	 * 
	 * @param getCustomerDeliveryInfoByMbrNoList
	 * @return List<CustomerDeliveryInfoResponse>
	 * @throws Exception
	 */
	List<CustomerDeliveryInfoResponse> getCustomerDeliveryInfoByMbrNoList(CustomerDetailRequest customerDetailRequest);

	/**
	 * 회원 상세 뷰 - getSiteNoList
	 * 
	 * @param getCustomerTermsAgreeInfoByMbrNoSiteNoList
	 * @return List<CustomerTermsAgreeInfoResponse>
	 * @throws Exception
	 */
	List<CustomerTermsAgreeInfoResponse> getCustomerTermsAgreeInfoByMbrNoSiteNoList(
			CustomerDetailRequest customerDetailRequest);

	/**
	 * 회원등급 이력 조회 수
	 * 
	 * @param getCustomerTermsAgreeInfoByMbrNoSiteNoList
	 * @return 회원등급 이력 조회 수 - Integer
	 * @throws Exception
	 */
	int getCustomerGradeHistoryByMemberNoCount(CustomerDetailRequest customerDetailRequest);

	/**
	 * 회원등급 이력 조회
	 * 
	 * @param customerDetailRequest
	 * @return 회원등급 이력 조회 - List<CustomerGradeHistoryResponse>
	 * @throws Exception
	 */
	List<CustomerGradeHistoryResponse> getCustomerGradeHistoryByMemberNoData(
			CustomerDetailRequest customerDetailRequest);

	/**
	 * 환불계좌관리
	 * 
	 * @param customerDetailRequest
	 * @return 환불계좌 정보 - CustomerRefundAccountInfoResponse
	 * @throws exception
	 */
	CustomerRefundAccountInfoResponse getCustomerRefundAccountInfoByMemberNo(
			CustomerDetailRequest customerDetailRequest);

	/**
	 * 환불계좌저장
	 * 
	 * @param etMbrRfdActnInfo
	 * @return
	 * @throws exception
	 */
	void saveCustomerRefundAccount(EtMbrRfdActnInfo etMbrRfdActnInfo) throws Exception;

	/**
	 * 회원 배송지 조회 수
	 * 
	 * @param customerDetailRequest
	 * @return 회원 배송지 조회 수 - Integer
	 * @throws exception
	 */
	int getCustomerDeliveryListCount(CustomerDetailRequest customerDetailRequest);

	/**
	 * 회원 배송지 조회
	 * 
	 * @param customerDetailRequest
	 * @return 회원 배송지 조회 - List<CustomerDeliveryInfoResponse>
	 * @throws exception
	 */
	List<CustomerDeliveryInfoResponse> getCustomerDeliveryList(CustomerDetailRequest customerDetailRequest);

	/**
	 * 회원상세 저장 저장
	 * 
	 * @param etMbrBase
	 * @return
	 * @throws exception
	 */
	void saveCustomerDetailAndOthersData(EtMbrBase etMbrBase) throws Exception;

	/**
	 * 회원상세 배송지 저장
	 * 
	 * @param etMbrBase
	 * @return
	 * @throws exception
	 */
	void setOthersDataByMbrNo(RawRealGridCUDRequest rawCudRequest) throws Exception;

	/**
	 * 동의정보 이력 조회 수
	 * 
	 * @param customerDetailRequest
	 * @return 동의정보 이력 조회 수 - Integer
	 * @throws exception
	 */
	int getCustomerTermsAgreeHistoryByMemberNoSiteNoCount(CustomerDetailRequest customerDetailRequest) throws Exception;

	/**
	 * 동의정보 이력 조회
	 * 
	 * @param customerDetailRequest
	 * @return 동의정보 이력 조회 - List<CustomerDeliveryInfoResponse>
	 * @throws exception
	 */
	List<CustomerTermsAgreeHistoryResponse> getCustomerTermsAgreeHistoryByMemberNoSiteNoData(
			CustomerDetailRequest customerDetailRequest) throws Exception;

}
