package com.andrea.feed.adaptor.web.controller;

import com.andrea.feed.adaptor.web.controller.vo.in.RequestFeedVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/feeds")
public class FeedRestController {

    private final Environment environment;

    @PostMapping
    public String createFeed(@RequestBody RequestFeedVo requestFeedVo) {
        log.info("requestFeedVo : {}", requestFeedVo);
        return "create feed";
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "health check : " + environment.getProperty("local.server.port");
    }
}
