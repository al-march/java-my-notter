package com.tracker.rest.task;

import com.tracker.db.entity.TaskEntity;
import com.tracker.rest.task.models.Task;
import com.tracker.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskMapper {
    Task
    one(TaskEntity entity) {
        return new Task(entity);
    }

    List<Task>
    list(List<TaskEntity> entities) {
        return Util.entityListToModel(entities, this::one);
    }
}
