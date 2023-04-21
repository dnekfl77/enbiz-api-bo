package com.enbiz.api.bo.app.dto.request.system;

import com.enbiz.api.bo.app.dto.request.realgrid.RealGridCUDRequest;
import com.enbiz.api.bo.app.entity.StUserBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterSystemNoticeRequest {
	private SystemNoticeCudRequest req;
	private RealGridCUDRequest<StUserBase> cudList;
}
