package com.green.greengram.user;

import com.green.greengram.common.config.exception.FeedErrorCode;
import com.green.greengram.common.config.exception.RestApiException;
import com.green.greengram.common.config.security.AuthenticationFacade;
import com.green.greengram.common.config.security.model.UserPrincipal;
import com.green.greengram.common.entity.FeedEntity;
import com.green.greengram.common.entity.UserEntity;
import com.green.greengram.feed.model.FeedVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthenticationFacade authFacade;
    private final UserRepository userRep;

    public List<FeedVo> selFeedList() {
        UserEntity userEntity = userRep.findById(authFacade.getLoginUserPk()).orElseThrow(() -> new RestApiException(FeedErrorCode.NO_FEED));
        return null;

    }
}
