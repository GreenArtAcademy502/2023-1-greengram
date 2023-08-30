package com.green.greengram.common.config.security;

import com.green.greengram.common.config.security.model.UserPrincipal;
import com.green.greengram.common.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    private Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    //로그인이 되어 있는지 확인
    public boolean isAuthenticated() { return getAuth() != null; }

    public UserEntity getLoginUser() {
        Authentication auth = getAuth();
        if(auth == null) { return null; }
        UserPrincipal userDetails = (UserPrincipal) getAuth().getPrincipal();
        return UserEntity.builder().iuser(userDetails.getIuser()).build();
    }

    public Long getLoginUserPk() {
        UserEntity userEntity = getLoginUser();
        if(userEntity == null) { return null; }
        return userEntity.getIuser();
    }
}
