package com.green.greengram.feed;

import com.green.greengram.common.entity.FeedCmtEntity;
import com.green.greengram.common.entity.FeedEntity;
import com.green.greengram.common.entity.FeedPicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedCmtRepository extends JpaRepository<FeedCmtEntity, Long> {
    List<FeedCmtEntity> findAllByFeedEntity(FeedEntity entity);
}

