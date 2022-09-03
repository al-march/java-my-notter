package com.notter.rest.note;

import com.notter.db.entity.CategoryEntity;
import com.notter.db.entity.CommentEntity;
import com.notter.db.entity.NoteEntity;
import com.notter.db.entity.UserEntity;
import com.notter.db.repository.CategoryRepo;
import com.notter.db.repository.CommentRepo;
import com.notter.db.repository.NoteRepo;
import com.notter.exception.EntityNotFoundException;
import com.notter.rest.note.models.CommentDto;
import com.notter.rest.note.models.Note;
import com.notter.rest.note.models.NoteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepo noteRepo;
    private final CategoryRepo categoryRepo;
    private final CommentRepo commentRepo;
    private final NoteMapper noteMapper;
    private final CommentMapper commentMapper;

    public NoteService(NoteRepo noteRepo, CategoryRepo categoryRepo, CommentRepo commentRepo, NoteMapper noteMapper, CommentMapper commentMapper) {
        this.noteRepo = noteRepo;
        this.categoryRepo = categoryRepo;
        this.commentRepo = commentRepo;
        this.noteMapper = noteMapper;
        this.commentMapper = commentMapper;
    }

    Note create(NoteDto dto, UserEntity user) {
        var entity = new NoteEntity();

        CategoryEntity category = null;
        try {
            category = getProject(dto.getProjectId(), user.getId());
        } catch (Exception ignored) {
        }

        entity.setUser(user);
        entity.setCategory(category);
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        noteRepo.save(entity);
        return noteMapper.one(entity);
    }

    Note update(NoteDto dto, Integer noteId, UserEntity user) {
        var entity = noteRepo.getOneByUser(user.getId(), noteId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        noteRepo.save(entity);
        return noteMapper.one(entity);
    }

    Note getOne(Integer noteId, UserEntity user) {
        var entity = noteRepo.getOneByUser(user.getId(), noteId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        var note = noteMapper.one(entity);
        note.setComments(commentMapper.list(entity.getComments()));
        return note;
    }

    List<Note> getAll(UserEntity user) {
        var entities = noteRepo.getAllByUser(user.getId());
        return noteMapper.list(entities);
    }

    Note setComment(Integer noteId, CommentDto dto, UserEntity user) {
        var noteEntity = noteRepo.getOneByUser(user.getId(), noteId);
        if (noteEntity == null) {
            throw new EntityNotFoundException();
        }

        var comments = noteEntity.getComments();
        var comment = createComment(dto, user);
        comments.add(comment);
        noteEntity.setComments(comments);
        noteRepo.save(noteEntity);

        var note = noteMapper.one(noteEntity);
        note.setComments(commentMapper.list(comments));
        return note;
    }

    private CommentEntity createComment(CommentDto comment, UserEntity user) {
        var entity = new CommentEntity();
        entity.setUser(user);
        entity.setContent(comment.getContent());
        commentRepo.save(entity);
        return entity;
    }

    CategoryEntity getProject(Integer projectId, Integer userId) {
        var entity = categoryRepo.getOneByUser(userId, projectId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }
}
