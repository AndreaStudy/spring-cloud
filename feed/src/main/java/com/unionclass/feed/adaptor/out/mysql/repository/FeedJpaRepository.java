package com.unionclass.feed.adaptor.out.mysql.repository;

import com.unionclass.feed.adaptor.out.mysql.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedJpaRepository extends JpaRepository<FeedEntity, Long> {
    Optional<FeedEntity> findByFeedUuid(String feedUuid);
    List<FeedEntity> findByAuthorId(String authorId);
    void deleteByFeedUuid(String feedUuid);
}
