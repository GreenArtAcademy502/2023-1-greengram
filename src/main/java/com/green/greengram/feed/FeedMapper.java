package com.green.greengram.feed;

import com.green.greengram.common.entity.FeedCmtEntity;
import com.green.greengram.feed.model.cmt.FeedCmtVo;
import com.green.greengram.feed.model.FeedVo;
import com.green.greengram.feed.model.FeedDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    List<FeedVo> selFeedList(FeedDto dto);
}
