package com.oshadhaviran.pointofsale.repo;

import com.oshadhaviran.pointofsale.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
