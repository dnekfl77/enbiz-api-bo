package com.enbiz.api.bo.app.controller.customer;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.enbiz.api.bo.app.service.customer.CustomerMgmtService;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;

@RestController
@Lazy
@RequiredArgsConstructor
@RequestMapping("/customer/customerMgmt")
public class CustomerMgmtController {
	private final CustomerMgmtService customerMgmtService;

	/**
	 * 회원 목록 수 조회
	 * 
	 * @param CustomerSearchRequest
	 * @return 회원 목록 수 - Integer
	 * @throws Exception
	 */
	@GetMapping("/getCustomerListCount")
	Response<Integer> getCustomerListCount( CustomerSearchRequest customerSearchRequest) throws Exception {
		return new Response<Integer>().setPayload(customerMgmtService.getCustomerListCount(customerSearchRequest));
	}

	/**
	 * 회원 목록 조회
	 * 
	 * @param CustomerSearchRequest
	 * @return 회원 목록 - List<CustomerSearchResponse>
	 * @throws Exception
	 */
	@GetMapping("/getCustomerList")
	Response<List<CustomerSearchResponse>> getCustomerList( CustomerSearchRequest customerSearchRequest)
			throws Exception {
		return new Response<List<CustomerSearchResponse>>()
				.setPayload(customerMgmtService.getCustomerList(customerSearchRequest));
	}

	/**
	 * 회원 상세 뷰 - getData
	 * 
	 * @param customerDetailRequest
	 * @return CustomerDetailResponseEx
	 * @throws Exception
	 */
	@GetMapping("/getCustomerDetail")
	Response<CustomerDetailResponseEx> getCustomerDetail( CustomerDetailRequest customerDetailRequest)
			throws Exception {
		return new Response<CustomerDetailResponseEx>()
				.setPayload(customerMgmtService.getCustomerDetail(customerDetailRequest));
	}

	/**
	 * 회원 상세 뷰 - getMbrNoList
	 * 
	 * @param customerDetailRequest
	 * @return List<CustomerDeliveryInfoResponse>
	 * @throws Exception
	 */
	@GetMapping("/getCustomerDeliveryInfoByMbrNoList")
	Response<List<CustomerDeliveryInfoResponse>> getCustomerDeliveryInfoByMbrNoList(
			 CustomerDetailRequest customerDetailRequest) throws Exception {
		return new Response<List<CustomerDeliveryInfoResponse>>()
				.setPayload(customerMgmtService.getCustomerDeliveryInfoByMbrNoList(customerDetailRequest));
	}

	/**
	 * 회원 상세 뷰 - getSiteNoList
	 * 
	 * @param customerDetailRequest
	 * @return List<CustomerTermsAgreeInfoResponse>
	 * @throws Exception
	 */
	@GetMapping("/getCustomerTermsAgreeInfoByMbrNoSiteNoList")
	Response<List<CustomerTermsAgreeInfoResponse>> getCustomerTermsAgreeInfoByMbrNoSiteNoList(
			 CustomerDetailRequest customerDetailRequest) throws Exception {
		return new Response<List<CustomerTermsAgreeInfoResponse>>()
				.setPayload(customerMgmtService.getCustomerTermsAgreeInfoByMbrNoSiteNoList(customerDetailRequest));
	}

	/**
	 * 회원등급 이력 조회 수
	 * 
	 * @param customerDetailRequest
	 * @return 회원등급 이력 조회 수 - Integer
	 * @throws Exception
	 */
	@GetMapping("/getCustomerGradeHistoryByMemberNoCount")
	Response<Integer> getCustomerGradeHistoryByMemberNoCount( CustomerDetailRequest customerDetailRequest)
			throws Exception {
		return new Response<Integer>()
				.setPayload(customerMgmtService.getCustomerGradeHistoryByMemberNoCount(customerDetailRequest));
	}

	/**
	 * 회원등급 이력 조회
	 * 
	 * @param customerDetailRequest
	 * @return 회원등급 이력 조회 - List<CustomerGradeHistoryResponse>
	 * @throws Exception
	 */
	@GetMapping("/getCustomerGradeHistoryByMemberNoData")
	Response<List<CustomerGradeHistoryResponse>> getCustomerGradeHistoryByMemberNoData(
			 CustomerDetailRequest customerDetailRequest) throws Exception {
		return new Response<List<CustomerGradeHistoryResponse>>()
				.setPayload(customerMgmtService.getCustomerGradeHistoryByMemberNoData(customerDetailRequest));
	}

	/**
	 * 환불 계좌 관리
	 * 
	 * @param customerDetailRequest
	 * @return 환불계좌 정보 - CustomerRefundAccountInfoResponse
	 * @throws exception
	 */
	@GetMapping("/getCustomerRefundAccountInfoByMemberNo")
	Response<CustomerRefundAccountInfoResponse> getCustomerRefundAccountInfoByMemberNo(
			 CustomerDetailRequest customerDetailRequest) throws Exception {
		return new Response<CustomerRefundAccountInfoResponse>()
				.setPayload(customerMgmtService.getCustomerRefundAccountInfoByMemberNo(customerDetailRequest));
	}

	/**
	 * 환불 계좌 저장
	 * 
	 * @param etMbrRfdActnInfo
	 * @return
	 * @throws exception
	 */
	@PostMapping("/saveCustomerRefundAccount")
	Response<String> saveCustomerRefundAccount(@RequestBody EtMbrRfdActnInfo etMbrRfdActnInfo) throws Exception {
		customerMgmtService.saveCustomerRefundAccount(etMbrRfdActnInfo);
		return new Response<String>().setPayload("success");
	}

	/**
	 * 회원 배송지 조회 수
	 * 
	 * @param customerDetailRequest
	 * @return 회원 배송지 조회 수 - Integer
	 * @throws exception
	 */
	@GetMapping("/getCustomerDeliveryListCount")
	Response<Integer> getCustomerDeliveryListCount( CustomerDetailRequest customerDetailRequest)
			throws Exception {
		return new Response<Integer>()
				.setPayload(customerMgmtService.getCustomerDeliveryListCount(customerDetailRequest));
	}

	/**
	 * 회원 배송지 조회
	 * 
	 * @param customerDetailRequest
	 * @return 회원 배송지 조회 - List<CustomerDeliveryInfoResponse>
	 * @throws exception
	 */
	@GetMapping("/getCustomerDeliveryList")
	Response<List<CustomerDeliveryInfoResponse>> getCustomerDeliveryList(
			 CustomerDetailRequest customerDetailRequest) throws Exception {
		return new Response<List<CustomerDeliveryInfoResponse>>()
				.setPayload(customerMgmtService.getCustomerDeliveryList(customerDetailRequest));
	}

	/**
	 * 회원상세 저장
	 * 
	 * @param etMbrBase
	 * @return
	 * @throws exception
	 */
	@PostMapping("/saveCustomerDetailAndOthersData")
	Response<String> saveCustomerDetailAndOthersData(@RequestBody EtMbrBase etMbrBase) throws Exception {
		customerMgmtService.saveCustomerDetailAndOthersData(etMbrBase);
		return new Response<String>().setPayload("success");
	}

	/**
	 * 회원상세 배송지 저장
	 * 
	 * @param etMbrBase
	 * @return
	 * @throws exception
	 */
	@PostMapping("/setOthersDataByMbrNo")
	Response<String> setOthersDataByMbrNo(@RequestBody Map<String, Object> request) throws Exception {

		RawRealGridCUDRequest rawCudRequest = (RawRealGridCUDRequest) request.get("rawCUDRequest");

		// 배송비정책 그리드

		customerMgmtService.setOthersDataByMbrNo(rawCudRequest);
		return new Response<String>().setPayload("success");
	}

	/**
	 * 동의정보 이력 조회 수
	 * 
	 * @param customerDetailRequest
	 * @return 동의정보 이력 조회 수 - Integer
	 * @throws exception
	 */
	@GetMapping("/getCustomerTermsAgreeHistoryByMemberNoSiteNoCount")
	Response<Integer> getCustomerTermsAgreeHistoryByMemberNoSiteNoCount(
			 CustomerDetailRequest customerDetailRequest) throws Exception {
		return new Response<Integer>().setPayload(
				customerMgmtService.getCustomerTermsAgreeHistoryByMemberNoSiteNoCount(customerDetailRequest));
	}

	/**
	 * 동의정보 이력 조회
	 * 
	 * @param customerDetailRequest
	 * @return 동의정보 이력 조회 - List<CustomerDeliveryInfoResponse>
	 * @throws exception
	 */
	@GetMapping("/getCustomerTermsAgreeHistoryByMemberNoSiteNoData")
	Response<List<CustomerTermsAgreeHistoryResponse>> getCustomerTermsAgreeHistoryByMemberNoSiteNoData(
			 CustomerDetailRequest customerDetailRequest) throws Exception {
		return new Response<List<CustomerTermsAgreeHistoryResponse>>().setPayload(
				customerMgmtService.getCustomerTermsAgreeHistoryByMemberNoSiteNoData(customerDetailRequest));
	}

}
