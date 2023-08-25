package com.green.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeedRegVo {
    private long ifeed;
    private String location;
    private String ctnt;
    private String createdAt;
}
