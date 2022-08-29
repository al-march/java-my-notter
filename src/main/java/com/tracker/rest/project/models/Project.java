package com.tracker.rest.project.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tracker.db.entity.ProjectEntity;
import com.tracker.rest.task.models.Task;
import lombok.Data;

import java.util.List;

@Data
public class Project {

    Integer userId;
    String name;
    String description;

    @JsonInclude(Include.NON_NULL)
    List<Task> tasks;

    public Project(ProjectEntity entity) {
        this.userId = entity.getUser().getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }
}
