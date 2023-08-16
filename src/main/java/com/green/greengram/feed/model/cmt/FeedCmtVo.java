package com.green.greengram.feed.model.cmt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class FeedCmtVo {
    private Long icmt;
    private String cmt;
    private String createdAt;
    private Long ifeed;
    private Long iuser;
    private String writer;
    private String writerPic;
    private int isMore; //0: 댓글 더 없음, 1: 댓글 더 있음
}
