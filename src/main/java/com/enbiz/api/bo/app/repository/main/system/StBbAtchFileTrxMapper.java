package com.enbiz.api.bo.app.repository.main.system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.entity.StBbAtchFile;

@Repository
@Lazy
public interface StBbAtchFileTrxMapper {
	int insertStBbAtchFile(StBbAtchFile stBbAtchFile);

	int deleteStBbAtchFile(StBbAtchFile stBbAtchFile);
}
