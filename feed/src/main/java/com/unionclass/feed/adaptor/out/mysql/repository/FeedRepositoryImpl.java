package com.unionclass.feed.adaptor.out.mysql.repository;

import com.unionclass.feed.adaptor.out.mysql.mapper.FeedEntityMapper;
import com.unionclass.feed.application.port.out.FeedRepositoryPort;
import com.unionclass.feed.domain.model.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class FeedRepositoryImpl implements FeedRepositoryPort {

    private final FeedJpaRepository feedJpaRepository;
    private final FeedEntityMapper feedEntityMapper;

    @Override
    public void save(Feed feed) {
       feedJpaRepository.save(feedEntityMapper.toEntity(feed));
    }

    @Override
    public void update(Feed feed) {

    }

    @Override
    public Feed findByFeedUuid(String feedUuid) {
        return feedEntityMapper.toDomain(
                feedJpaRepository.findByFeedUuid(feedUuid)
                        .orElseThrow(() -> new RuntimeException("Feed not found"))
        );
    }

    @Override
    public List<Feed> findByAuthorId(String authorId) {
        return List.of();
    }

    @Override
    public void deleteByFeedUuid(String feedUuid) {

    }
}
