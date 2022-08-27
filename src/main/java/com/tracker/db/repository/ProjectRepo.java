package com.tracker.db.repository;

import com.tracker.db.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepo extends JpaRepository<ProjectEntity, Integer> {

    @Query("SELECT p FROM project p WHERE p.user.id = ?1")
    List<ProjectEntity> getAllByUser(Integer userId);

    @Query("SELECT p FROM project p WHERE p.user.id = ?1 AND p.id = ?2")
    ProjectEntity getOneByUser(Integer userId, Integer projectId);
}
