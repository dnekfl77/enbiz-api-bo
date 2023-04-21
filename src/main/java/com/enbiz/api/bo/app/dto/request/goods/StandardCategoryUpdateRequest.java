package com.enbiz.api.bo.app.dto.request.goods;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ========================== 표준 분류 관리 Update Request DTO
 * ==========================
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardCategoryUpdateRequest extends BaseCommonEntity {

	private String stdCtgNo; // 표준카테고리번호
	private String stdCtgNm; // 표준카테고리명
	private String useYn; // 사용여부
	private Integer sortSeq; // 정렬순서
	private String mdId; // MD아이디
	private String safeCertiNeedYn; // 안전인증필요여부
	private String goodsNotiLisartCd; // 상품고시품목코드
}
