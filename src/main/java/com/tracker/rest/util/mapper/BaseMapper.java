package com.tracker.rest.util.mapper;

import com.tracker.util.Util;

import java.util.List;

public abstract class BaseMapper<Entity, Model> {
    public abstract Model one(Entity entity);

    public List<Model>
    list(List<Entity> entities) {
        return Util.entityListToModel(entities, this::one);
    }
}
