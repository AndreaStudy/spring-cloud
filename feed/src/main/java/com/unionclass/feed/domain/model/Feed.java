package com.unionclass.feed.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Feed {

    private Long id;
    private String feedUuid;
    private String title;
    private String content;
    private String authorId;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Feed(
            String feedUuid,
            String title,
            String content,
            String authorId,
            boolean isDeleted,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.feedUuid = feedUuid;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void update(String title, String content) {

        if(title == null || title.isEmpty()) {
            throw new IllegalArgumentException("title is empty");
        }
        if(content == null || content.isEmpty()) {
            throw new IllegalArgumentException("content is empty");
        }
        this.title = title;
        this.content = content;
    }

    public static Feed from(String title, String content, String authorId) {
        return Feed.builder()
                .feedUuid(UUID.randomUUID().toString())
                .title(title)
                .content(content)
                .authorId(authorId)
                .isDeleted(false)
                .build();
    }

}
