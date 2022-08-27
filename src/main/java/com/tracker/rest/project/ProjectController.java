package com.tracker.rest.project;

import com.tracker.config.security.CustomUserDetails;
import com.tracker.rest.project.models.Project;
import com.tracker.rest.project.models.ProjectDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/v1/project")
@Validated
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public @ResponseBody
    Project create(
            @Valid @RequestBody ProjectDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return projectService.create(dto, user.getUserEntity());
    }

    @PutMapping("/{projectId}")
    public @ResponseBody
    Project update(
            @PathVariable Integer projectId,
            @Valid @RequestBody ProjectDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return projectService.update(dto, projectId, user.getUserEntity());
    }

    @GetMapping("/{projectId}")
    public @ResponseBody
    Project get(
            @PathVariable Integer projectId,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return projectService.getOne(projectId, user.getUserEntity());
    }

    @GetMapping
    public @ResponseBody
    List<Project> getAll(
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return projectService.getAll(user.getUserEntity());
    }
}
