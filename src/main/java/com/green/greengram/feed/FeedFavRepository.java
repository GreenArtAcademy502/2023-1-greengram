package com.green.greengram.feed;

import com.green.greengram.common.entity.FeedFavEntity;
import com.green.greengram.common.entity.FeedFavId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedFavRepository extends JpaRepository<FeedFavEntity, FeedFavId> {
}
