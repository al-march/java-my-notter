package com.tracker.db.repository;

import com.tracker.db.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<ProjectEntity, Integer> {
}
