package com.unionclass.feed.adaptor.out.mysql.mapper;

import com.unionclass.feed.adaptor.out.mysql.entity.FeedEntity;
import com.unionclass.feed.domain.model.Feed;
import org.springframework.stereotype.Component;

@Component
public class FeedEntityMapper {

    public FeedEntity toEntity(Feed feed) {
        return FeedEntity.builder()
                .feedUuid(feed.getFeedUuid())
                .title(feed.getTitle())
                .authorId(feed.getAuthorId())
                .content(feed.getContent())
                .isDeleted(feed.isDeleted())
                .build();
    }

    public Feed toDomain(FeedEntity feedEntity) {
        return Feed.builder()
                .feedUuid(feedEntity.getFeedUuid())
                .title(feedEntity.getTitle())
                .authorId(feedEntity.getAuthorId())
                .content(feedEntity.getContent())
                .isDeleted(feedEntity.isDeleted())
                .createdAt(feedEntity.getCreatedAt())
                .updatedAt(feedEntity.getUpdatedAt())
                .build();
    }

}
