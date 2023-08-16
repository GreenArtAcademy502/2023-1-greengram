package com.green.greengram.feed.model;

import com.green.greengram.feed.model.cmt.FeedCmtVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedVo {
    private Long ifeed;
    private String location;
    private String ctnt;
    private Long iuser;
    private String createdAt;
    private String unm;
    private String pic;
    private int favCnt;
    private int isFav;
    private List<FeedPicVo> imgList;
    private FeedCmtVo cmt;
}
