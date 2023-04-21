package com.enbiz.api.bo.app.service.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;
import com.enbiz.api.bo.app.dto.request.menu.TopMenuRequest;
import com.enbiz.api.bo.app.dto.request.messaging.ReceiveMessage;
import com.enbiz.api.bo.app.dto.response.menu.LeftMenuResponse;
import com.enbiz.api.bo.app.dto.response.menu.TopMenuResponse;
import com.enbiz.api.bo.app.repository.main.main.MainMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Lazy
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MainServiceImpl implements MainService {
	@Autowired
	private final MainMapper mainMapper;

	@Override
	public List<TopMenuResponse> getTopMenuList(LoginRequest loginRequest) throws Exception {
		return mainMapper.getTopMenuList(loginRequest);
	}

	@Override
	public List<LeftMenuResponse> getLeftMenuList(TopMenuRequest params) throws Exception {
		List<LeftMenuResponse> retLeftMenuResponseList = new ArrayList<>();

		List<LeftMenuResponse> leftMenuResponseList = mainMapper.getLeftMenuList(params);

		for (LeftMenuResponse leftMenuResponse : leftMenuResponseList) {
			if (1 == leftMenuResponse.getLevel()) {
				LeftMenuResponse tempLeftMenuResponse = LeftMenuResponse.builder()
						.rtTgtSeq(leftMenuResponse.getRtTgtSeq()).rtTgtNm(leftMenuResponse.getRtTgtNm())
						.uprRtTgtSeq(leftMenuResponse.getUprRtTgtSeq()).sortSeq(leftMenuResponse.getSortSeq())
						.level(leftMenuResponse.getLevel()).leafMenuYn(leftMenuResponse.getLeafMenuYn())
						.callUrl(leftMenuResponse.getCallUrl()).hierarchy(leftMenuResponse.getHierarchy()).build();
				retLeftMenuResponseList.add(tempLeftMenuResponse);
			}
		}

		String uprRtTgtSeq = "";

		for (LeftMenuResponse objParentMenu : retLeftMenuResponseList) {
			List<LeftMenuResponse> childMenuList = new ArrayList<>();

			for (LeftMenuResponse leftMenuResponse : leftMenuResponseList) {
				if (2 == leftMenuResponse.getLevel()) {
					if (StringUtils.equals(objParentMenu.getRtTgtSeq(), leftMenuResponse.getUprRtTgtSeq())) {
						LeftMenuResponse childMenu = LeftMenuResponse.builder().rtTgtSeq(leftMenuResponse.getRtTgtSeq())
								.rtTgtNm(leftMenuResponse.getRtTgtNm()).uprRtTgtSeq(leftMenuResponse.getUprRtTgtSeq())
								.sortSeq(leftMenuResponse.getSortSeq()).level(leftMenuResponse.getLevel())
								.leafMenuYn(leftMenuResponse.getLeafMenuYn()).callUrl(leftMenuResponse.getCallUrl())
								.hierarchy(leftMenuResponse.getHierarchy()).build();
						childMenuList.add(childMenu);
					}
				}
			}

			objParentMenu.setChildMenuList(childMenuList);
		}

		return retLeftMenuResponseList;
	}

	@Override
	public ReceiveMessage getAlarmMessage(LoginRequest loginRequest) {
		return mainMapper.getAlarmMessage(loginRequest);
	}
}
