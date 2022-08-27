package com.tracker.rest.project;

import com.tracker.db.entity.ProjectEntity;
import com.tracker.rest.project.models.Project;
import com.tracker.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMapper {
    Project
    oneToProject(ProjectEntity entity) {
        return new Project(entity.getName(), entity.getDescription(), entity.getTasks());
    }

    List<Project>
    listToProjects(List<ProjectEntity> entities) {
        return Util.entityListToModel(entities, this::oneToProject);
    }
}
