package com.tracker.rest.project;

import com.tracker.db.entity.ProjectEntity;
import com.tracker.rest.project.models.Project;
import com.tracker.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMapper {
    Project
    one(ProjectEntity entity) {
        return new Project(entity.getName(), entity.getDescription(), entity.getTasks());
    }

    List<Project>
    list(List<ProjectEntity> entities) {
        return Util.entityListToModel(entities, this::one);
    }
}
