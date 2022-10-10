package com.example.springmvc.auth.repository;

import com.example.springmvc.auth.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository for manipulation of {@link User} domain.
 */
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

}
