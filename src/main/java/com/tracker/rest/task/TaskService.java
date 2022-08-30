package com.tracker.rest.task;

import com.tracker.db.entity.ProjectEntity;
import com.tracker.db.entity.TaskEntity;
import com.tracker.db.entity.UserEntity;
import com.tracker.db.repository.ProjectRepo;
import com.tracker.db.repository.TaskRepo;
import com.tracker.exception.EntityNotFoundException;
import com.tracker.rest.task.models.Task;
import com.tracker.rest.task.models.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepo;
    private final ProjectRepo projectRepo;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepo taskRepo, ProjectRepo projectRepo, TaskMapper taskMapper) {
        this.taskRepo = taskRepo;
        this.projectRepo = projectRepo;
        this.taskMapper = taskMapper;
    }

    Task create(TaskDto dto, UserEntity user) {
        var entity = new TaskEntity();
        var project = getProject(dto.getProjectId(), user.getId());

        entity.setUser(user);
        entity.setProject(project);
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        taskRepo.save(entity);
        return taskMapper.one(entity);
    }

    Task update(TaskDto dto, Integer taskId, UserEntity user) {
        var entity = taskRepo.getOneByUser(user.getId(), taskId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        taskRepo.save(entity);
        return taskMapper.one(entity);
    }

    Task getOne(Integer taskId, UserEntity user) {
        var entity = taskRepo.getOneByUser(user.getId(), taskId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        var task = taskMapper.one(entity);
        task.setComments(entity.getComments());
        return task;
    }

    List<Task> getAll(UserEntity user) {
        var entities = taskRepo.getAllByUser(user.getId());
        return taskMapper.list(entities);
    }

    ProjectEntity getProject(Integer projectId, Integer userId) {
        var entity = projectRepo.getOneByUser(userId, projectId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }
}
