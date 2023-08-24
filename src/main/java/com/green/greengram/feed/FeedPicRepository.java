package com.green.greengram.feed;

import com.green.greengram.common.entity.FeedPicEntity;
import com.green.greengram.common.entity.FeedPicId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedPicRepository extends JpaRepository<FeedPicEntity, FeedPicId> {

}
