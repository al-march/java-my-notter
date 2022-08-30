package com.tracker.rest.task.models;

import com.tracker.db.entity.CommentEntity;
import lombok.Data;

@Data
public class Comment {
    Integer id;
    Integer userId;
    String content;

    public Comment(CommentEntity entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.content = entity.getContent();
    }
}
