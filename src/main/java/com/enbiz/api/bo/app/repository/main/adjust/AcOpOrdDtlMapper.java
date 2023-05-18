package com.enbiz.api.bo.app.repository.main.adjust;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.adjust.CooperCommissionRequest;
import com.enbiz.api.bo.app.dto.request.adjust.DeliveryAmountRequest;
import com.enbiz.api.bo.app.dto.request.adjust.SalesDetailsRequest;
import com.enbiz.api.bo.app.dto.request.adjust.VendorCommissionRequest;
import com.enbiz.api.bo.app.dto.response.adjust.CooperCommissionResponse;
import com.enbiz.api.bo.app.dto.response.adjust.DeliveryAmountResponse;
import com.enbiz.api.bo.app.dto.response.adjust.SalesDetailsResponse;
import com.enbiz.api.bo.app.dto.response.adjust.VendorCommissionResponse;

@Repository
@Lazy
public interface AcOpOrdDtlMapper {
	//매출 마감
	int getSalesDetailsListCount(SalesDetailsRequest salesDetailsRequest);
	
	List<SalesDetailsResponse> getSalesDetailsList(SalesDetailsRequest salesDetailsRequest);
	
	SalesDetailsResponse getSalesDetailsListSum(SalesDetailsRequest salesDetailsRequest);
	
	SalesDetailsResponse getSalesCloseValidation(SalesDetailsRequest salesDetailsRequest);
	
	SalesDetailsResponse selectAdjCloseYn(SalesDetailsRequest salesDetailsRequest);
	
	//배송비조회
	int getDeliveryAmountListCount(DeliveryAmountRequest deliveryAmountRequest);
	
	List<DeliveryAmountResponse> getDeliveryAmountList(DeliveryAmountRequest deliveryAmountRequest);
//	
	//업체매출수수료조회
	int getVendorCommissionListCount(VendorCommissionRequest vendorCommissionRequest);
	
	List<VendorCommissionResponse> getVendorCommissionList(VendorCommissionRequest vendorCommissionRequest);
	
//	//제휴사수수료조회
	int getCooperCommissionListCount(CooperCommissionRequest cooperCommissionRequest);
	
	List<CooperCommissionResponse> getCooperCommissionList(CooperCommissionRequest cooperCommissionRequest);
	
	int getCooperCommissionDetailListCount(CooperCommissionRequest cooperCommissionRequest);
	
	List<CooperCommissionResponse> getCooperCommissionDetailList(CooperCommissionRequest cooperCommissionRequest);
}
