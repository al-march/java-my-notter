package com.notter.rest.category;

import com.notter.db.entity.CategoryEntity;
import com.notter.db.entity.UserEntity;
import com.notter.db.repository.CategoryRepo;
import com.notter.db.repository.NoteRepo;
import com.notter.exception.EntityNotFoundException;
import com.notter.rest.category.models.Category;
import com.notter.rest.category.models.CategoryDto;
import com.notter.rest.note.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    final CategoryRepo categoryRepo;
    final NoteRepo noteRepo;
    final CategoryMapper categoryMapper;
    final NoteMapper noteMapper;

    public CategoryService(CategoryRepo categoryRepo, NoteRepo noteRepo, CategoryMapper categoryMapper, NoteMapper noteMapper) {
        this.categoryRepo = categoryRepo;
        this.noteRepo = noteRepo;
        this.categoryMapper = categoryMapper;
        this.noteMapper = noteMapper;
    }

    Category create(CategoryDto dto, UserEntity user) {
        var entity = new CategoryEntity();

        entity.setUser(user);
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        categoryRepo.save(entity);
        return categoryMapper.one(entity);
    }

    Category update(CategoryDto dto, Integer projectId, UserEntity user) {
        var entity = categoryRepo.getOneByUser(user.getId(), projectId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        categoryRepo.save(entity);
        return categoryMapper.one(entity);
    }

    Category getOne(Integer projectId, UserEntity user) {
        var entity = categoryRepo.getOneByUser(user.getId(), projectId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        var project = categoryMapper.one(entity);
        var notes = noteRepo.getByProject(projectId);
        project.setNotes(noteMapper.list(notes));
        return project;
    }

    List<Category> getAll(UserEntity user) {
        var entities = categoryRepo.getAllByUser(user.getId());
        return categoryMapper.list(entities);
    }
}
