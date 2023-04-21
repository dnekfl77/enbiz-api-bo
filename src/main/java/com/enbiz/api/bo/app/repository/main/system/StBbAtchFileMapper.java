package com.enbiz.api.bo.app.repository.main.system;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.enbiz.api.bo.app.dto.response.system.SystemNoticeAttachFileResponse;

@Repository
@Lazy
public interface StBbAtchFileMapper {
	int getMaxFileSeq(String bbcNo);

	List<SystemNoticeAttachFileResponse> getStBbAtchFileList(String bbcNo);
}
