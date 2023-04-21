package com.enbiz.api.bo.app.repository.main.display;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.request.display.PrDispGrpBaseRequest;
import com.enbiz.api.bo.app.dto.request.display.PrDispGrpMappInfoRequest;
import com.enbiz.api.bo.app.dto.request.display.PrMkdpBaseRequest;
import com.enbiz.api.bo.app.dto.response.display.PrDispGrpBaseRespons;
import com.enbiz.api.bo.app.dto.response.display.PrDispGrpMappInfoRespons;
import com.enbiz.api.bo.app.dto.response.display.PrMkdpBaseResponse;

/**
 * 기획전 그룹 관리 Mapper
 * 
 * @author N.J.Kim
 *
 */
@Repository
@Lazy
public interface PrDispGrpBaseMapper {

	/**
	 * 기획전 그룹 목록 수 조회
	 * 
	 * @param prPrDispGrpMappInfoInfoRequest
	 * @return 기획전 관리 목록 수
	 * @throws Exception
	 */
	int getPrDispGrpBaseListCount(PrDispGrpBaseRequest prDispGrpBaseRequest);

	/**
	 * 기획전 그룹 목록 조회
	 * 
	 * @param prPrDispGrpMappInfoInfoRequest
	 * @return 기획전 관리 목록
	 * @throws Exception
	 */
	List<PrDispGrpBaseRespons> getPrDispGrpBaseList(PrDispGrpBaseRequest prDispGrpBaseRequest);

	/**
	 * 기획전 그룹 목록 등록
	 * 
	 * @param prPrDispGrpMappInfoInfo 등록
	 * @throws Exception
	 */
	int insertPrDispGrpBaseList(List<PrDispGrpBaseRequest> record);

	/**
	 * 기획전 그룹 목록 수정
	 * 
	 * @param ccPrDispGrpMappInfoInfo 등록
	 * @throws Exception
	 */
	int updatePrDispGrpBaseList(List<PrDispGrpBaseRequest> ccFotrInfoRequest);

	/**
	 * 기획전 그룹 삭제 목록 처리
	 * 
	 * @param deleteList 삭제 목록
	 * @throws Exception
	 */
	int deletePrDispGrpBaseList(List<PrDispGrpBaseRequest> ccFotrInfoRequest);

	/**
	 * 기획전 목록 수 조회
	 * 
	 * @param prPrDispGrpMappInfoInfoRequest
	 * @return 기획전 관리 목록 수
	 * @throws Exception
	 */
	int getPrDispGrpMappInfoListCount(PrDispGrpMappInfoRequest prDispGrpMappInfoRequest);

	/**
	 * 기획전 목록 조회
	 * 
	 * @param prPrDispGrpMappInfoInfoRequest
	 * @return 기획전 관리 목록
	 * @throws Exception
	 */
	List<PrDispGrpMappInfoRespons> getPrDispGrpMappInfoList(PrDispGrpMappInfoRequest prDispGrpMappInfoRequest);

	/**
	 * 기획전 그룹 목록 등록
	 * 
	 * @param prPrDispGrpMappInfoInfo 등록
	 * @throws Exception
	 */
	int insertPrDispGrpMappInfoList(List<PrDispGrpMappInfoRequest> prDispGrpMappInfoRequest);

	/**
	 * 기획전 그룹 목록 수정
	 * 
	 * @param ccPrDispGrpMappInfoInfo 등록
	 * @throws Exception
	 */
	int updatePrDispGrpMappInfoList(List<PrDispGrpMappInfoRequest> prDispGrpMappInfoRequest);

	/**
	 * 기획전 그룹 목록 삭제
	 * 
	 * @param deleteList 삭제 목록
	 * @throws Exception
	 */
	int deletePrDispGrpMappInfoList(List<PrDispGrpMappInfoRequest> prDispGrpMappInfoRequest);

	/**
	 * 기획전 수 조회
	 * 
	 * @param ccCcFotrInfoInfoRequest
	 * @return 기획전 관리 목록 수
	 * @throws Exception
	 */
	int getMarketDisplayListCount(PrMkdpBaseRequest prMkdpBaseRequest);

	/**
	 * 기획전 조회
	 * 
	 * @param ccCcFotrInfoInfoRequest
	 * @return 기획전 관리 목록
	 * @throws Exception
	 */
	List<PrMkdpBaseResponse> getMarketDisplayList(PrMkdpBaseRequest prMkdpBaseRequest);
}