package com.tracker.rest.tag;

import com.tracker.config.security.CustomUserDetails;
import com.tracker.rest.tag.models.Tag;
import com.tracker.rest.tag.models.TagDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/v1/tag")
@Validated
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public @ResponseBody
    Tag create(
            @Valid @RequestBody TagDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return tagService.create(dto, user.getUserEntity());
    }

    @PutMapping("/{tagId}")
    public @ResponseBody
    Tag update(
            @Valid @RequestBody TagDto dto,
            @PathVariable Integer tagId,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return tagService.update(dto, tagId, user.getUserEntity());
    }

    @GetMapping
    public @ResponseBody
    List<Tag> getAll(
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return tagService.getAll(user.getUserEntity());
    }
}
