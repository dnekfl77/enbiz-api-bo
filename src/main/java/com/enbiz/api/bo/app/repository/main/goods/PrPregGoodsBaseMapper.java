package com.enbiz.api.bo.app.repository.main.goods;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.goods.GoodsApprovalMgmtRequest;
import com.enbiz.api.bo.app.dto.request.goods.GoodsSaveTempRequest;
import com.enbiz.api.bo.app.dto.response.common.DashboardTrustVendorGoodsApprovalResponse;
import com.enbiz.api.bo.app.dto.response.goods.GoodsApprovalMgmtResponse;
import com.enbiz.api.bo.app.dto.response.goods.GoodsSaveTempResponse;
import com.enbiz.api.bo.app.dto.response.goods.TemporaryGeneralGoodsResponse;
import com.enbiz.api.bo.app.dto.response.goods.TemporaryPackageGoodsResponse;

/**
 * 가등록 상품기본 DAO
 */
@Repository
@Lazy
public interface PrPregGoodsBaseMapper {

	// ============================================= 여기부터
	/**
	 * 임시 일반상품 상세 > 임시 일반상품 정보 조회
	 * 
	 * @param pregGoodsNo
	 * @return
	 */
	TemporaryGeneralGoodsResponse getTemporaryGeneralGoodsInfo(String pregGoodsNo);

	/**
	 * 임시 묶음상품 상세 > 임시 묶음상품 정보 조회
	 * 
	 * @param pregGoodsNo
	 * @return
	 */
	TemporaryPackageGoodsResponse getTemporaryPackageGoodsInfo(String pregGoodsNo);

	// ============================================= 여기까지

	/**
	 * 상품 임시 저장 목록 수 조회
	 * 
	 * @param request
	 * @return 품 임시 저장 목록 수
	 * @throws Exception
	 */
	int getGoodsTemporarySaveListCount(GoodsSaveTempRequest request);

	/**
	 * 상품 임시 저장 목록 조회
	 * 
	 * @param request
	 * @return 상품 임시 저장 목록
	 * @throws Exception
	 */
	List<GoodsSaveTempResponse> getGoodsTemporarySaveList(GoodsSaveTempRequest request);

	/**
	 * 상품 승인 목록 수 조회
	 * 
	 * @param request
	 * @return
	 */
	int getGoodsApprovalListCount(GoodsApprovalMgmtRequest request);

	/**
	 * 상품 승인 목록 조회
	 * 
	 * @param request
	 * @return
	 */
	List<GoodsApprovalMgmtResponse> getGoodsApprovalList(GoodsApprovalMgmtRequest request);

	List<DashboardTrustVendorGoodsApprovalResponse> getDashboardTrustVendorGoodsApprovalList();

	int getDashboardGoodsTodaySoldOutCnt();

	int getDashboardGoods2WeekSoldOutCnt();
}
