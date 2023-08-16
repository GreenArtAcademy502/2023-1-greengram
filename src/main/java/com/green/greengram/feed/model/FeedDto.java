package com.green.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Getter
@Builder
public class FeedDto {
    private Long iuserForFav; //내가 feed에 좋아요 했는지 알기 위해 쓰는 로그인 유저 iuser값
    private Long iuserForMyFeed;
    private int startIdx;
    private int size;
}
