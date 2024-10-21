package com.unionclass.feed.application.service;

import com.unionclass.feed.application.port.in.FeedUseCase;
import com.unionclass.feed.application.port.out.FeedRepositoryPort;
import com.unionclass.feed.domain.model.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedService implements FeedUseCase {

    private final FeedRepositoryPort feedRepositoryPort;

    @Override
    public void createFeed(String title, String content, String authorId) {
        feedRepositoryPort.save(Feed.from(title, content, authorId));
    }

    @Override
    public void updateFeed(String feedUuid, String newTitle, String newContent) {

    }

    @Override
    public Feed getFeedByFeedUuid(String feedUuid) {
        return feedRepositoryPort.findByFeedUuid(feedUuid);
    }

    @Override
    public List<Feed> getFeedsByAuthorId(String authorId) {
        return List.of();
    }

    @Override
    public void deleteFeed(String feedUuid) {

    }
}
