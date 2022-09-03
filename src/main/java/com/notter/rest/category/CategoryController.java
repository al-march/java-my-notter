package com.notter.rest.category;

import com.notter.config.security.CustomUserDetails;
import com.notter.rest.category.models.Category;
import com.notter.rest.category.models.CategoryDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/v1/category")
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public @ResponseBody
    Category create(
            @Valid @RequestBody CategoryDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return categoryService.create(dto, user.getUserEntity());
    }

    @PutMapping("/{projectId}")
    public @ResponseBody
    Category update(
            @PathVariable Integer projectId,
            @Valid @RequestBody CategoryDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return categoryService.update(dto, projectId, user.getUserEntity());
    }

    @GetMapping("/{projectId}")
    public @ResponseBody
    Category get(
            @PathVariable Integer projectId,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return categoryService.getOne(projectId, user.getUserEntity());
    }

    @GetMapping
    public @ResponseBody
    List<Category> getAll(
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return categoryService.getAll(user.getUserEntity());
    }
}
