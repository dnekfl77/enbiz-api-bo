package com.enbiz.api.bo.app.dto.request.goods;

import org.apache.ibatis.type.Alias;

import com.enbiz.common.base.entity.BaseCommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ========================== 표준 분류 관리 Request DTO ==========================
 */
@Alias("StandardCategoryRequest")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardCategoryRequest extends BaseCommonEntity {

	private String stdCtgNo; // 표준분류번호
}
