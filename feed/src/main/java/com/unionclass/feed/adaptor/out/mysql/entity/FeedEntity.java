package com.unionclass.feed.adaptor.out.mysql.entity;

import com.unionclass.feed.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class FeedEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feedUuid;
    private String title;
    private String content;
    private String authorId;
    private boolean isDeleted;

    @Builder
    public FeedEntity(String feedUuid, String title, String content, String authorId, boolean isDeleted) {
        this.feedUuid = feedUuid;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.isDeleted = isDeleted;
    }

}
