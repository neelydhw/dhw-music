package com.dhw.music.repository;

import com.dhw.music.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Neely
 * @date 2023/3/24
 */
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);
}
