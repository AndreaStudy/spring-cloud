package com.unionclass.feed.adaptor.in.rest.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class FeedResponseVo {

    private String feedUuid;
    private String title;
    private String content;
    private String authorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public FeedResponseVo(String feedUuid, String title, String content, String authorId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.feedUuid = feedUuid;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
