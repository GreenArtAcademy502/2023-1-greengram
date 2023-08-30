package com.green.greengram.feed;

import com.green.greengram.common.config.exception.FeedErrorCode;
import com.green.greengram.common.config.exception.RestApiException;
import com.green.greengram.feed.model.cmt.FeedCmtSaveDto;
import com.green.greengram.common.config.security.AuthenticationFacade;
import com.green.greengram.common.entity.*;
import com.green.greengram.common.utils.MyFileUtils;
import com.green.greengram.feed.model.*;
import com.green.greengram.feed.model.cmt.FeedCmtVo;
import com.green.greengram.user.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final AuthenticationFacade auth;
    private final MyFileUtils myFileUtils;

    private final FeedMapper mapper;
    private final UserRepository userRep;
    private final FeedRepository feedRep;
    private final FeedPicRepository feedPicRep;
    private final FeedCmtRepository feedCmtRep;
    private final FeedFavRepository feedFavRep;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public FeedRegVo reg(MultipartFile[] imgs, FeedRegReqDto dto) {
        if(imgs == null) { throw new RestApiException(FeedErrorCode.NEED_FEED_IMGS); }

        FeedEntity entity = new FeedEntity();
        entity.setCtnt(dto.getCtnt());
        entity.setLocation(dto.getLocation());
        entity.setUserEntity(auth.getLoginUser());

        feedRep.saveAndFlush(entity);
        entityManager.detach(entity);
        FeedEntity result = feedRep.findById(entity.getIfeed()).get();

        log.info("user-name : {}", result.getUserEntity().getUnm());
        String target = "feed/" + result.getIfeed();

        for(MultipartFile img : imgs) {
            String fileNm = myFileUtils.transferTo(img, target);

            FeedPicEntity feedPicEntity = FeedPicEntity.builder()
                    .feedPicId(FeedPicId.builder()
                            .pic(fileNm)
                            .feedEntity(result)
                            .build())
                    .build();
            feedPicRep.save(feedPicEntity);
        }

       // entityManager.refresh(result);
        log.info("result : {}", result);
        return FeedRegVo.builder()
                .ctnt(result.getCtnt())
                .location(result.getLocation())
                .ifeed(result.getIfeed())
                .createdAt(result.getCreatedAt().toString())
                .build();
    }

    public List<FeedVo> selFeedList(Pageable pageable) {
        log.info("iuserForFav: {}", auth.getLoginUser().getIuser());
        log.info("page {}, offset {}", pageable.getPageNumber(), pageable.getOffset());
        FeedDto dto = FeedDto.builder()
                .iuserForFav(auth.getLoginUser().getIuser())
                .startIdx((pageable.getPageNumber() - 1) * pageable.getPageSize())
                .size(pageable.getPageSize())
                .build();
        return mapper.selFeedList(dto);
    }

    /********************************************    fav [start]  *********/
    public int feedFavProc(long ifeed, int type) {
        FeedEntity feedEntity = feedRep.getReferenceById(ifeed);
        UserEntity userEntity = userRep.findById(auth.getLoginUser().getIuser()).get();

        FeedFavId feedFavId = FeedFavId.builder()
                .feedEntity(feedEntity)
                .userEntity(userEntity)
                .build();

        FeedFavEntity feedFavEntity = FeedFavEntity.builder()
                .feedFavId(feedFavId)
                .build();

        if(type == 0) { //삭제
            feedFavRep.delete(feedFavEntity);
        } else { //등록
            feedFavRep.save(feedFavEntity);
        }
        return 1;
    }
    /********************************************    fav [end]  *********/

    /********************************************    cmt [start]  *********/
    public FeedCmtVo insFeedCmt(FeedCmtSaveDto dto) {
        //FeedEntity feedEntity = feedRep.getReferenceById(dto.getIfeed());
        //UserEntity userEntity = userRep.getReferenceById(auth.getLoginUser().getIuser());
        FeedEntity feedEntity = FeedEntity.builder().ifeed(dto.getIfeed()).build();
        UserEntity userEntity = UserEntity.builder().iuser(auth.getLoginUser().getIuser()).build();

        FeedCmtEntity feedCmtEntity = FeedCmtEntity.builder()
                .cmt(dto.getCmt())
                .feedEntity(feedEntity)
                .userEntity(userEntity)
                .build();

        FeedCmtEntity result = feedCmtRep.save(feedCmtEntity);

        return FeedCmtVo.builder()
                .icmt(result.getIcmt())
                .cmt(result.getCmt())
                .createdAt(result.getCreatedAt().toString())
                .ifeed(feedEntity.getIfeed())
                .iuser(userEntity.getIuser())
                .writer(userEntity.getUnm())
                .writerPic(userEntity.getPic())
                .build();
    }


    public List<FeedCmtVo> selFeedCmtList(Long ifeed) {
        //FeedEntity feedEntity = feedRep.getReferenceById(ifeed);
        //List<FeedCmtEntity> list = feedCmtRep.findAllByFeedEntity(feedEntity);
        List<FeedCmtEntity> list = feedCmtRep.selFeedCmtAll(ifeed);
        log.info("list : {}", list);
        return list.stream()
                .map(item -> FeedCmtVo.builder()
                        .icmt(item.getIcmt())
                        .cmt(item.getCmt())
                        .createdAt(item.getCreatedAt().toString())
                        .ifeed(item.getFeedEntity().getIfeed())
                        .iuser(item.getUserEntity().getIuser())
                        .writer(item.getUserEntity().getUnm())
                        .writerPic(item.getUserEntity().getPic())
                        .build())
                .toList();
    }

    /********************************************    cmt [end]  *********/
}
