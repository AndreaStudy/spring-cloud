package com.unionclass.feed.adaptor.in.rest;

import com.unionclass.feed.adaptor.in.mapper.FeedVoMapper;
import com.unionclass.feed.adaptor.in.rest.vo.FeedRequestVo;
import com.unionclass.feed.adaptor.in.rest.vo.FeedResponseVo;
import com.unionclass.feed.application.port.in.FeedUseCase;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/feeds")
public class FeedRestController {

    private final Environment environment;
    private final FeedUseCase feedUseCase;
    private final FeedVoMapper feedVoMapper;

    @Operation(summary = "Create Feed")
    @PostMapping("/add")
    public String createFeed(@RequestBody FeedRequestVo feedRequestVo) {

        log.info("requestFeedVo : {}", feedRequestVo);
        feedUseCase.createFeed(feedRequestVo.getTitle(), feedRequestVo.getContent(), feedRequestVo.getAuthorId());
        return "create feed";
        // create feed
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "health check" + environment.getProperty("local.server.port");
    }

    @GetMapping("/token-test")
    public String tokenTest(
            @RequestHeader(value = "Authorization") String token
    ) {
        return "token test" + environment.getProperty("local.server.port");
    }

    @GetMapping("/get-feed/{feedUuid}")
    public ResponseEntity<FeedResponseVo> getFeed(
            @PathVariable String feedUuid
    ) {
        return ResponseEntity.ok(feedVoMapper.toResponseVo(feedUseCase.getFeedByFeedUuid(feedUuid)));
    }
}
