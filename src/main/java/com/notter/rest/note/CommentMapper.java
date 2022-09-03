package com.notter.rest.note;

import com.notter.db.entity.CommentEntity;
import com.notter.rest.note.models.Comment;
import com.notter.rest.util.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper extends BaseMapper<CommentEntity, Comment> {
    public Comment one(CommentEntity entity) {
        return new Comment(entity);
    }
}
