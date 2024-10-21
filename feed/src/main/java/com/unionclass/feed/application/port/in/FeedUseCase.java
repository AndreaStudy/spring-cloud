package com.unionclass.feed.application.port.in;

import com.unionclass.feed.domain.model.Feed;

import java.util.List;

public interface FeedUseCase {

    void createFeed(String title, String content, String authorId);
    void updateFeed(String feedUuid, String newTitle, String newContent);
    Feed getFeedByFeedUuid(String feedUuid);
    List<Feed> getFeedsByAuthorId(String authorId);
    void deleteFeed(String feedUuid);

}
