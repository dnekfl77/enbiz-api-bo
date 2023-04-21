package com.enbiz.api.bo.app.repository.main.goods;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.goods.StandardCategoryRequest;
import com.enbiz.api.bo.app.dto.response.goods.StandardCategoryChildResponse;
import com.enbiz.api.bo.app.dto.response.goods.StandardCategoryGoodsResponse;
import com.enbiz.api.bo.app.dto.response.goods.StandardCategoryInfoResponse;
import com.enbiz.api.bo.app.dto.response.goods.StandardCategoryTreeResponse;

/**
 * 상품표준분류 DAO
 */
@Repository
@Lazy
public interface PrStdCtgMapper {

	/**
	 * 상품표준분류 계층구조 목록 조회
	 * 
	 * @return 상품표준분류 계층구조 목록
	 */
	List<StandardCategoryTreeResponse> getPrStdCtgListWithHierarchy();

	/**
	 * 상품표준분류 기본정보 조회
	 * 
	 * @param request
	 * @return 상품표준분류 기본정보
	 */
	StandardCategoryInfoResponse getStandardCategoryInfo(StandardCategoryRequest request);

	/**
	 * 하위 표준 분류 목록 수
	 * 
	 * @param request
	 * @return 하위 표준 분류 목록 수
	 */
	int getChildStandardCategoryListCount(StandardCategoryRequest request);

	/**
	 * 하위 표준 분류 목록 조회
	 * 
	 * @param request
	 * @return 하위 표준 분류 목록
	 */
	List<StandardCategoryChildResponse> getChildStandardCategoryList(StandardCategoryRequest request);

	/**
	 * 표준 분류 상품 목록 수
	 * 
	 * @param request
	 * @return 표준 분류 상품 수
	 */
	int getStandardCategoryGoodsListCount(StandardCategoryRequest request);

	/**
	 * 표준 분류 상품 목록 조회
	 * 
	 * @param request
	 * @return 표준 분류 상품 목록
	 */
	List<StandardCategoryGoodsResponse> getStandardCategoryGoodsList(StandardCategoryRequest request);

	/**
	 * 표준 분류 연결 전시 목록 수 조회
	 * 
	 * @param request
	 * @return 표준 분류 연결 전시 목록 수
	 */
	int getStandardCategoryDisplayListCount(StandardCategoryRequest request);

}