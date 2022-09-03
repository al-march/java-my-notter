package com.notter.rest.category;

import com.notter.db.entity.CategoryEntity;
import com.notter.rest.category.models.Category;
import com.notter.rest.util.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper extends BaseMapper<CategoryEntity, Category> {
    public Category one(CategoryEntity entity) {
        return new Category(entity);
    }
}
