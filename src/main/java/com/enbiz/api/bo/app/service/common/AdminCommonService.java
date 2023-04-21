package com.enbiz.api.bo.app.service.common;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.enbiz.api.bo.app.dto.EncryptCUD;
import com.enbiz.api.bo.app.dto.MaskingCUD;
import com.enbiz.api.bo.app.dto.request.common.DashboardAlarmRequest;
import com.enbiz.api.bo.app.dto.response.common.DashboardAlarmResponse;
import com.enbiz.api.bo.app.dto.response.common.DashboardGoodsQnaIngResponse;
import com.enbiz.api.bo.app.dto.response.common.DashboardTrustVendorGoodsApprovalResponse;
import com.enbiz.api.bo.app.entity.SmsMsg;

public interface AdminCommonService {

	/**
	 * 비밀번호 초기화시 SMS 발송
	 * 
	 * @param smsMsg
	 * @throws Exception
	 */
	void insertInitPassWordSms(SmsMsg smsMsg) throws Exception;

	/**
	 * 마스킹 대상 조회
	 * 
	 * @throws Exception
	 */
	MaskingCUD getMaskingCUD() throws Exception;

	/**
	 * 암호화 대상 조회
	 * 
	 * @throws Exception
	 */
	EncryptCUD getEncryptCUD() throws Exception;

	// 이미지 저장 & 리사이징
	String resizeImageMultipartFile(MultipartFile file, Map<String, String> param) throws Exception;

	// 파일 저장
//    Map<String,String> uploadMultipartFile(MultipartFile file, AttacheFileKind kind, boolean temp) throws Exception;
//    //파일 리스트 저장
//    List<Map<String,String>> uploadMultipartFileList(List<MultipartFile> file, AttacheFileKind kind, boolean temp) throws Exception;
//    //에디터 리스트 저장
//    String uploadImgEditor(List<MultipartFile> files) throws Exception;
//    //임시파일 확정
//    boolean confirmFile();
//    //파일다운로드
//    ResponseEntity<byte[]> downloadFile(String fullPath, String originalFileName) throws IOException;

	List<DashboardAlarmResponse> getDashboardAlarmList(DashboardAlarmRequest dashboardAlarmRequest);

	List<DashboardGoodsQnaIngResponse> getDashboardGoodsQnaIngList();

	List<DashboardTrustVendorGoodsApprovalResponse> getDashboardTrustVendorGoodsApprovalList();

	int getDashboardGoodsTodayNewCnt();

	int getDashboardGoodsTodaySoldOutCnt();

	int getDashboardGoods2WeekSellingCnt();

	int getDashboardGoods2WeekSoldOutCnt();

	public Map<String, Object> getPermissionToViewPersonalInfo(String userId);
}
