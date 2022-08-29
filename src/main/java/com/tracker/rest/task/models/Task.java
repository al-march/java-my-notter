package com.tracker.rest.task.models;

import com.tracker.db.entity.TagEntity;
import com.tracker.db.entity.TaskEntity;
import lombok.Data;

import java.util.List;

@Data
public class Task {

    String name;
    String description;
    List<TagEntity> tags;

    public Task(TaskEntity entity) {
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.tags = entity.getTags();
    }
}
