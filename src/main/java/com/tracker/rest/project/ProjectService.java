package com.tracker.rest.project;

import com.tracker.db.entity.ProjectEntity;
import com.tracker.db.entity.UserEntity;
import com.tracker.db.repository.ProjectRepo;
import com.tracker.exception.EntityNotFoundException;
import com.tracker.rest.project.models.Project;
import com.tracker.rest.project.models.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    final ProjectRepo projectRepo;
    final ProjectMapper projectMapper;

    public ProjectService(ProjectRepo projectRepo, ProjectMapper projectMapper) {
        this.projectRepo = projectRepo;
        this.projectMapper = projectMapper;
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
        return projectMapper.one(entity);
    }

    List<Project> getAll(UserEntity user) {
        var entities = projectRepo.getAllByUser(user.getId());
        return projectMapper.list(entities);
    }
}
