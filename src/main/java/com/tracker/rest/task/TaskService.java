package com.tracker.rest.task;

import com.tracker.db.entity.CommentEntity;
import com.tracker.db.entity.ProjectEntity;
import com.tracker.db.entity.TaskEntity;
import com.tracker.db.entity.UserEntity;
import com.tracker.db.repository.CommentRepo;
import com.tracker.db.repository.ProjectRepo;
import com.tracker.db.repository.TaskRepo;
import com.tracker.exception.EntityNotFoundException;
import com.tracker.rest.task.models.CommentDto;
import com.tracker.rest.task.models.Task;
import com.tracker.rest.task.models.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepo;
    private final ProjectRepo projectRepo;
    private final CommentRepo commentRepo;
    private final TaskMapper taskMapper;
    private final CommentMapper commentMapper;

    public TaskService(TaskRepo taskRepo, ProjectRepo projectRepo, CommentRepo commentRepo, TaskMapper taskMapper, CommentMapper commentMapper) {
        this.taskRepo = taskRepo;
        this.projectRepo = projectRepo;
        this.commentRepo = commentRepo;
        this.taskMapper = taskMapper;
        this.commentMapper = commentMapper;
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
        task.setComments(commentMapper.list(entity.getComments()));
        return task;
    }

    List<Task> getAll(UserEntity user) {
        var entities = taskRepo.getAllByUser(user.getId());
        return taskMapper.list(entities);
    }

    Task setComment(Integer taskId, CommentDto dto, UserEntity user) {
        var taskEntity = taskRepo.getOneByUser(user.getId(), taskId);
        if (taskEntity == null) {
            throw new EntityNotFoundException();
        }

        var comments = taskEntity.getComments();
        var comment = createComment(dto, user);
        comments.add(comment);
        taskEntity.setComments(comments);
        taskRepo.save(taskEntity);

        var task = taskMapper.one(taskEntity);
        task.setComments(commentMapper.list(comments));
        return task;
    }

    private CommentEntity createComment(CommentDto comment, UserEntity user) {
        var entity = new CommentEntity();
        entity.setUser(user);
        entity.setContent(comment.getContent());
        commentRepo.save(entity);
        return entity;
    }

    ProjectEntity getProject(Integer projectId, Integer userId) {
        var entity = projectRepo.getOneByUser(userId, projectId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }
}
