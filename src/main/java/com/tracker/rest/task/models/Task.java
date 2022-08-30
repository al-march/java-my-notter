package com.tracker.rest.task.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tracker.db.entity.ProjectEntity;
import com.tracker.db.entity.TagEntity;
import com.tracker.db.entity.TaskEntity;
import com.tracker.util.Util;
import lombok.Data;

import java.util.List;

@Data
public class Task {

    Integer id;
    Integer projectId;
    String name;
    String description;
    List<TagEntity> tags;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Comment> comments;

    String linkId;

    List<Task> children;

    public Task(TaskEntity entity) {
        this.id = entity.getId();
        this.projectId = entity.getProject().getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.tags = entity.getTags();
        this.children = Util.entityListToModel(entity.getChildTasks(), Task::new);

        generateLink(entity.getProject());
    }

    private void generateLink(ProjectEntity project) {
        this.linkId = project.getPrefix() + "-" + this.id;
    }
}
