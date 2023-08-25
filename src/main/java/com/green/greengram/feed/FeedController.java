package com.green.greengram.feed;

import com.green.greengram.common.entity.FeedEntity;
import com.green.greengram.feed.model.*;
import com.green.greengram.feed.model.cmt.FeedCmtSaveDto;
import com.green.greengram.feed.model.cmt.FeedCmtVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/feed")
public class FeedController {

    private final FeedService service;

    //@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE })
    @PostMapping
    public FeedRegVo reg(MultipartFile[] imgs, FeedRegReqDto dto) {
        return service.reg(imgs, dto);
    }

    @GetMapping
    public List<FeedVo> selFeedList(@PageableDefault(sort="ifeed", direction = Sort.Direction.DESC, size=20) Pageable pageable) {
        return service.selFeedList(pageable);
    }

    @PostMapping("/cmt")
    public FeedCmtVo insFeedCmt(@RequestBody FeedCmtSaveDto dto) {
        return service.insFeedCmt(dto);
    }

    @GetMapping("/{ifeed}/cmt")
    public List<FeedCmtVo> cmtList(@PathVariable Long ifeed) {
        return service.selFeedCmtList(ifeed);
    }


    @GetMapping("/{ifeed}/fav")
    public int feedFavProc(@PathVariable long ifeed, int type) { //type: 1 - ins(등록), 0 - del(취소)
        return service.feedFavProc(ifeed, type);
    }
}
