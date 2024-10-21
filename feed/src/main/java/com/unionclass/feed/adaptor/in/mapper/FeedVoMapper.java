package com.unionclass.feed.adaptor.in.mapper;

import com.unionclass.feed.adaptor.in.rest.vo.FeedResponseVo;
import com.unionclass.feed.domain.model.Feed;
import org.springframework.stereotype.Component;

@Component
public class FeedVoMapper {

    public FeedResponseVo toResponseVo(Feed feed) {
        return FeedResponseVo.builder()
                .feedUuid(feed.getFeedUuid())
                .title(feed.getTitle())
                .content(feed.getContent())
                .authorId(feed.getAuthorId())
                .createdAt(feed.getCreatedAt())
                .updatedAt(feed.getUpdatedAt())
                .build();
    }
}
