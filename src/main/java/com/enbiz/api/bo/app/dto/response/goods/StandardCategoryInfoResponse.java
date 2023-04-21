package com.enbiz.api.bo.app.dto.response.goods;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ========================== 표준 분류 정보 Response DTO ==========================
 */
@Alias("StandardCategoryInfoResponse")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardCategoryInfoResponse extends BaseCommonEntity {

	private String stdCtgNo; // 표준카테고리번호
	private String stdCtgNm; // 표준카테고리명

	private String uprStdCtgNo; // 상위표준카테고리번호
	private String uprStdCtgNm; // 상위표준카테고리명

	private Integer sortSeq; // 정렬순서

	private String useYn; // 사용여부
	private String leafCtgYn; // 리프카테고리 여부
	private String safeCertiNeedYn; // 안전인증필요 여부

	private String mdId; // MD아이디
	private String mdNm; // MD명

	private String goodsNotiLisartCd; // 상품고시품목코드(PR012)
	private String goodsNotiLisartCdNm; // 상품고시품목코드명

}
