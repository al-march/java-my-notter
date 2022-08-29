package com.tracker.rest.project;

import com.tracker.db.entity.ProjectEntity;
import com.tracker.db.entity.UserEntity;
import com.tracker.db.repository.ProjectRepo;
import com.tracker.db.repository.TaskRepo;
import com.tracker.exception.EntityNotFoundException;
import com.tracker.rest.project.models.Project;
import com.tracker.rest.project.models.ProjectDto;
import com.tracker.rest.task.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    final ProjectRepo projectRepo;
    final TaskRepo taskRepo;
    final ProjectMapper projectMapper;
    final TaskMapper taskMapper;

    public ProjectService(ProjectRepo projectRepo, TaskRepo taskRepo, ProjectMapper projectMapper, TaskMapper taskMapper) {
        this.projectRepo = projectRepo;
        this.taskRepo = taskRepo;
        this.projectMapper = projectMapper;
        this.taskMapper = taskMapper;
    }

    Project create(ProjectDto dto, UserEntity user) {
        var entity = new ProjectEntity();

        entity.setUser(user);
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        projectRepo.save(entity);
        return projectMapper.one(entity);
    }

    Project update(ProjectDto dto, Integer projectId, UserEntity user) {
        var entity = projectRepo.getOneByUser(user.getId(), projectId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        projectRepo.save(entity);
        return projectMapper.one(entity);
    }

    Project getOne(Integer projectId, UserEntity user) {
        var entity = projectRepo.getOneByUser(user.getId(), projectId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        var project = projectMapper.one(entity);
        var tasks = taskRepo.getByProject(projectId);
        project.setTasks(taskMapper.list(tasks));
        return project;
    }

    List<Project> getAll(UserEntity user) {
        var entities = projectRepo.getAllByUser(user.getId());
        return projectMapper.list(entities);
    }
}
