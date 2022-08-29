package com.tracker.rest.tag.models;

import com.tracker.db.entity.TagEntity;
import lombok.Data;

@Data
public class Tag {
    Integer id;
    Integer userId;
    String name;

    public Tag(TagEntity entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.name = entity.getName();
    }
}
