package com.andrea.feed.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Feed {

    private Long id;
    private String title;
    private String content;
    private String authorId;

    public static Feed createFeed(){
        return Feed.builder()
                .title("title")
                .content("content")
                .authorId("authorId")
                .build();
    }
}
