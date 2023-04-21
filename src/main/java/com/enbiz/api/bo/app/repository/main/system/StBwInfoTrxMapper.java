package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StBwInfo;

@Repository
@Lazy
public interface StBwInfoTrxMapper {
	/**
	 * 금칙어 등록
	 */
	void insertBadWord(StBwInfo stBwInfo);

	/**
	 * 금칙어 수정
	 */
	void updateBadWord(StBwInfo stBwInfo);

	/**
	 * 금칙어 삭제
	 */
	void deleteBadWord(StBwInfo stBwInfo);
}
