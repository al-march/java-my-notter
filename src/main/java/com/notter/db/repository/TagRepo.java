package com.notter.db.repository;

import com.notter.db.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepo extends JpaRepository<TagEntity, Integer> {
    @Query("SELECT t FROM tag t WHERE t.user.id = ?1")
    List<TagEntity> getAllByUser(Integer userId);

    @Query("SELECT t FROM tag t WHERE t.user.id = ?1 AND t.id = ?2")
    TagEntity getOneByUser(Integer userId, Integer tagId);
}
