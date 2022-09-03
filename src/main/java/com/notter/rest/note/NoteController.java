package com.notter.rest.note;

import com.notter.config.security.CustomUserDetails;
import com.notter.rest.note.models.CommentDto;
import com.notter.rest.note.models.Note;
import com.notter.rest.note.models.NoteDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/v1/note")
@Validated
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public @ResponseBody
    Note create(
            @Valid @RequestBody NoteDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return noteService.create(dto, user.getUserEntity());
    }

    @PutMapping("/{noteId}")
    public @ResponseBody
    Note update(
            @PathVariable Integer noteId,
            @Valid @RequestBody NoteDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return noteService.update(dto, noteId, user.getUserEntity());
    }

    @GetMapping("/{noteId}")
    public @ResponseBody
    Note getOne(
            @PathVariable Integer noteId,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return noteService.getOne(noteId, user.getUserEntity());
    }

    @GetMapping
    public @ResponseBody
    List<Note> getAll(
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return noteService.getAll(user.getUserEntity());
    }

    @PostMapping("/{noteId}/comment")
    public @ResponseBody
    Note addComment(
            @PathVariable Integer noteId,
            @Valid @RequestBody CommentDto dto,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return noteService.setComment(noteId, dto, user.getUserEntity());
    }
}
