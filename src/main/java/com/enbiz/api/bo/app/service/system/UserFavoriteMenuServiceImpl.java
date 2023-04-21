package com.enbiz.api.bo.app.service.system;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enbiz.api.bo.app.dto.login.CurrentUser;
import com.enbiz.api.bo.app.dto.request.menu.TopMenuRequest;
import com.enbiz.api.bo.app.dto.request.system.UserFavoriteMenuRequest;
import com.enbiz.api.bo.app.dto.response.menu.LeftMenuResponse;
import com.enbiz.api.bo.app.dto.response.system.UserFavoriteMenuResponse;
import com.enbiz.api.bo.app.entity.StUserFvtInfo;
import com.enbiz.api.bo.app.repository.main.system.StUserFvtInfoMapper;
import com.enbiz.api.bo.app.repository.main.system.StUserFvtInfoTrxMapper;
import com.enbiz.common.base.Validator;
import com.enbiz.common.base.exception.MessageResolver;

import lombok.RequiredArgsConstructor;

/**
 * 즐겨찾기관리 서비스 IMPL
 */
@Service
@Lazy
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserFavoriteMenuServiceImpl implements UserFavoriteMenuMgmtService {

	private final StUserFvtInfoMapper stUserFvtInfoMapper;
	private final StUserFvtInfoTrxMapper stUserFvtInfoTrxMapper;

	@Override
	public List<UserFavoriteMenuResponse> getUserFavoriteMenuList(UserFavoriteMenuRequest userFavoriteMenuRequest) {
		return stUserFvtInfoMapper.getUserFavoriteMenuList(userFavoriteMenuRequest);
	}

	@Override
	public int getUserFavoriteMenuListCount(UserFavoriteMenuRequest userFavoriteMenuRequest) {
		return stUserFvtInfoMapper.getUserFavoriteMenuListCount(userFavoriteMenuRequest);
	}

	@Override
	public int checkDuplicateUserFavoriteMenu(UserFavoriteMenuRequest UserFavoriteMenuRequest) {
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserFavoriteMenuRequest.setUserId(currentUser.getLoginId());
		return stUserFvtInfoMapper.checkDuplicateUserFavoriteMenu(UserFavoriteMenuRequest);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void registUserFavoriteMenu(UserFavoriteMenuRequest UserFavoriteMenuRequest) throws Exception {
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		StUserFvtInfo stUserFvtInfo = new StUserFvtInfo();
		BeanUtils.copyProperties(stUserFvtInfo, UserFavoriteMenuRequest);

		stUserFvtInfo.setUserId(currentUser.getLoginId());
		stUserFvtInfo.setUseYn("Y");
		stUserFvtInfo.setSortSeq(1L);
		stUserFvtInfo.setSysRegId(currentUser.getLoginId());

		Validator.throwIfEmpty(stUserFvtInfo.getUserId(),
				MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "사용자ID" }));
		Validator.throwIfEmpty(stUserFvtInfo.getRtTgtSeq(),
				MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "권한대상순번" }));
		Validator.throwIfEmpty(stUserFvtInfo.getSysRegId(),
				MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "등록자ID" }));

		stUserFvtInfoTrxMapper.insertStUserFvtInfo(stUserFvtInfo);
	}

	@Override
	public void modifyUserFavoriteMenu(List<StUserFvtInfo> updateList) throws Exception {
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		for (StUserFvtInfo stUserFvtInfo : updateList) {
			stUserFvtInfo.setUserId(currentUser.getLoginId());
			Validator.throwIfEmpty(stUserFvtInfo.getUserId(),
					MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "사용자ID" }));
			Validator.throwIfEmpty(stUserFvtInfo.getRtTgtSeq(),
					MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "매뉴번호" }));
			Validator.throwIfEmpty(stUserFvtInfo.getSortSeq(),
					MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "정렬순서" }));
			Validator.throwIfEmpty(stUserFvtInfo.getUseYn(),
					MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "사용여부" }));
			stUserFvtInfoTrxMapper.updateStUserFvtInfo(stUserFvtInfo);
		}
	}

	@Override
	public void deleteUserFavoriteMenu(List<StUserFvtInfo> deleteList) throws Exception {
		CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		for (StUserFvtInfo stUserFvtInfo : deleteList) {
			stUserFvtInfo.setUserId(currentUser.getLoginId());
			Validator.throwIfEmpty(stUserFvtInfo.getUserId(),
					MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "사용자ID" }));
			Validator.throwIfEmpty(stUserFvtInfo.getRtTgtSeq(),
					MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "매뉴번호" }));
			stUserFvtInfoTrxMapper.deleteStUserFvtInfo(stUserFvtInfo);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public void saveUserFavoriteMenu(List<StUserFvtInfo> updateList, List<StUserFvtInfo> deleteList) throws Exception {
		modifyUserFavoriteMenu(updateList);
		deleteUserFavoriteMenu(deleteList);
	}

	@Override
	public List<LeftMenuResponse> getFavoriteMenu(TopMenuRequest topMenuRequest) {
		Validator.throwIfEmpty(topMenuRequest.getUserId(),
				MessageResolver.getMessage("adminCommon.message.parameter.empty", new String[] { "사용자ID" }));
		return stUserFvtInfoMapper.getFvtMenuList(topMenuRequest);
	}

}
