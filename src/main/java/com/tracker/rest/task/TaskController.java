package com.tracker.rest.task;

import com.tracker.config.security.CustomUserDetails;
import com.tracker.rest.task.models.Task;
import com.tracker.rest.task.models.TaskDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/v1/task")
@Validated
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public @ResponseBody
    Task create(
            @Valid @RequestBody TaskDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return taskService.create(dto, user.getUserEntity());
    }

    @PutMapping("/{taskId}")
    public @ResponseBody
    Task update(
            @PathVariable Integer taskId,
            @Valid @RequestBody TaskDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return taskService.update(dto, taskId, user.getUserEntity());
    }

    @GetMapping("/{taskId}")
    public @ResponseBody
    Task getOne(
            @PathVariable Integer taskId,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return taskService.getOne(taskId, user.getUserEntity());
    }

    @GetMapping
    public @ResponseBody
    List<Task> getAll(
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return taskService.getAll(user.getUserEntity());
    }

}
