package com.tracker.rest.tag;

import com.tracker.db.entity.TagEntity;
import com.tracker.rest.tag.models.Tag;
import com.tracker.rest.util.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class TagMapper extends BaseMapper<TagEntity, Tag> {
    public Tag one(TagEntity tagEntity) {
        return new Tag(tagEntity);
    }
}
