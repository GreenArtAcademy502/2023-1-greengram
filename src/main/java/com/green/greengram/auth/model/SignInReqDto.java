package com.green.greengram.auth.model;

import com.green.greengram.common.config.security.model.ProviderType;
import lombok.Data;

@Data
public class SignInReqDto {
    private String uid;
    private String upw;
}
