package com.tracker.rest.project.models;

import com.tracker.db.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Project {
    String name;
    String description;
    List<TaskEntity> tasks;
}
