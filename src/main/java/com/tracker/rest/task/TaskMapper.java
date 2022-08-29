package com.tracker.rest.task;

import com.tracker.db.entity.TaskEntity;
import com.tracker.rest.task.models.Task;
import com.tracker.rest.util.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper extends BaseMapper<TaskEntity, Task> {
    public Task one(TaskEntity entity) {
        return new Task(entity);
    }
}
