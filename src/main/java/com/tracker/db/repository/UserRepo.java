package com.tracker.db.repository;

import com.tracker.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT u FROM user u WHERE u.email = ?1")
    UserEntity findByEmail(String email);
}
