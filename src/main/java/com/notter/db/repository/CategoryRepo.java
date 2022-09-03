package com.notter.db.repository;

import com.notter.db.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {

    @Query("SELECT p FROM category p WHERE p.user.id = ?1")
    List<CategoryEntity> getAllByUser(Integer userId);

    @Query("SELECT p FROM category p WHERE p.user.id = ?1 AND p.id = ?2")
    CategoryEntity getOneByUser(Integer userId, Integer projectId);
}
