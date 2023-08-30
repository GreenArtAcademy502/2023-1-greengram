package com.green.greengram.feed;

import com.green.greengram.common.entity.FeedCmtEntity;
import com.green.greengram.common.entity.FeedEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedCmtRepository extends JpaRepository<FeedCmtEntity, Long> {
    List<FeedCmtEntity> findAllByFeedEntity(FeedEntity entity);

    @Query("SELECT a FROM FeedCmtEntity a join fetch a.userEntity b WHERE a.feedEntity.ifeed = :ifeed ORDER BY a.icmt ASC")
    List<FeedCmtEntity> selFeedCmtAll(@Param("ifeed") Long ifeed);
}

