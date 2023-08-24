package com.green.greengram.auth.model;

import lombok.Data;

@Data
public class SignUpReqDto {
    private String uid;
    private String upw;
    private String unm;
    private String email;
}
