package com.unionclass.feed.application.port.out;

import com.unionclass.feed.domain.model.Feed;

import java.util.List;
import java.util.Optional;

public interface FeedRepositoryPort {

    void save(Feed feed);
    void update(Feed feed);
    Feed findByFeedUuid(String feedUuid);
    List<Feed> findByAuthorId(String authorId);
    void deleteByFeedUuid(String feedUuid);

}
