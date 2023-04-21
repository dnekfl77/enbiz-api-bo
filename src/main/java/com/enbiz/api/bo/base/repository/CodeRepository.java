package com.enbiz.api.bo.base.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;
import com.enbiz.api.bo.app.dto.response.AuthorityAccessResponse;
import com.enbiz.api.bo.app.repository.main.common.CodeRepositoryMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CodeRepository {

    private final CodeRepositoryMapper codeRepositoryMapper;

    public String getButtonByPageRoleList(LoginRequest loginRequest) throws Exception{
        if(loginRequest.getCaloUrl() == null || loginRequest.getCaloUrl().isEmpty()) {
            return "";
        }

        List<AuthorityAccessResponse> stRtTgtBaseList = codeRepositoryMapper.getButtonByPageRoleList(loginRequest);
        StringBuilder builder = new StringBuilder();

        for(AuthorityAccessResponse authorityAccessResponse : stRtTgtBaseList){
            if(!builder.toString().isEmpty()){
                builder.append(",");
            }
            if (StringUtils.equals("N", authorityAccessResponse.getAuthorityAccessYn())) {
                builder.append("#").append(authorityAccessResponse.getBtnId());
            }
        }

        return builder.toString();

    }
}

