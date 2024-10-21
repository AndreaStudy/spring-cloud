package com.unionclass.feed.domain.service;

import com.unionclass.feed.domain.model.Feed;

public class FeedDomainService {

    public Boolean isFeedValid(String title, String content, String authorId) {
        return title != null && !title.isEmpty() && content != null && !content.isEmpty() && authorId != null && !authorId.isEmpty();
    }

    public void updateFeed(Feed feed, String newTitle, String newContent) {
        feed.update(newTitle, newContent);
    }

}
