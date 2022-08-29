package com.tracker.rest.project;

import com.tracker.db.entity.ProjectEntity;
import com.tracker.rest.project.models.Project;
import com.tracker.rest.util.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper extends BaseMapper<ProjectEntity, Project> {
    public Project one(ProjectEntity entity) {
        return new Project(entity);
    }
}
