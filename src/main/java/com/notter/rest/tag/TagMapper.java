package com.notter.rest.tag;

import com.notter.db.entity.TagEntity;
import com.notter.rest.tag.models.Tag;
import com.notter.rest.util.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class TagMapper extends BaseMapper<TagEntity, Tag> {
    public Tag one(TagEntity tagEntity) {
        return new Tag(tagEntity);
    }
}
