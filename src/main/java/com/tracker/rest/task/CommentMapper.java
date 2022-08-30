package com.tracker.rest.task;

import com.tracker.db.entity.CommentEntity;
import com.tracker.rest.task.models.Comment;
import com.tracker.rest.util.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper extends BaseMapper<CommentEntity, Comment> {
    public Comment one(CommentEntity entity) {
        return new Comment(entity);
    }
}
