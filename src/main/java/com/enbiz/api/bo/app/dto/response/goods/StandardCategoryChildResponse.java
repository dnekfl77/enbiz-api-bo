package com.enbiz.api.bo.app.dto.response.goods;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ========================== 하위 표준 분류 Response DTO ==========================
 */
@Alias("StandardCategoryChildResponse")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardCategoryChildResponse extends BaseCommonEntity {

	private String stdCtgNo; // 표준카테고리번호
	private String stdCtgNm; // 표준카테고리명
	private String uprStdCtgNo; // 상위표준카테고리번호

	private String useYn; // 사용여부
	private Integer sortSeq; // 정렬순서
	private String leafCtgYn; // 리프카테고리 여부

	private String leafCtgYnChangePossible; // 리프표준분류여부 변경 가능여부 (N이면 밑에 자식이 있다는거다...leaf로 변경 못함)

}
