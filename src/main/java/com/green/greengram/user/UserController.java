package com.green.greengram.user;

import com.green.greengram.feed.model.FeedVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService service;

    @GetMapping("/feed")
    public List<FeedVo> selFeedList(@PageableDefault(sort="ifeed", direction = Sort.Direction.DESC, size=20) Pageable pageable) {
        return service.selFeedList(pageable);
        return null;
    }

}
