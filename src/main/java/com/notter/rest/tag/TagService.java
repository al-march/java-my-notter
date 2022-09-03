package com.notter.rest.tag;

import com.notter.db.entity.TagEntity;
import com.notter.db.entity.UserEntity;
import com.notter.db.repository.TagRepo;
import com.notter.exception.EntityNotFoundException;
import com.notter.rest.tag.models.Tag;
import com.notter.rest.tag.models.TagDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepo tagRepo;
    private final TagMapper tagMapper;

    public TagService(TagRepo tagRepo, TagMapper tagMapper) {
        this.tagRepo = tagRepo;
        this.tagMapper = tagMapper;
    }

    Tag create(TagDto dto, UserEntity user) {
        var entity = new TagEntity();
        entity.setUser(user);
        entity.setName(dto.getName());
        tagRepo.save(entity);
        return tagMapper.one(entity);
    }

    Tag update(TagDto dto, Integer tagId, UserEntity user) {
        var entity = tagRepo.getOneByUser(user.getId(), tagId);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        entity.setName(dto.getName());
        tagRepo.save(entity);
        return tagMapper.one(entity);
    }

    List<Tag> getAll(UserEntity user) {
        var entities = tagRepo.getAllByUser(user.getId());
        return tagMapper.list(entities);
    }
}
