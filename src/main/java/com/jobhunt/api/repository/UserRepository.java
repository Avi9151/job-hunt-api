package com.jobhunt.api.repository;

import com.jobhunt.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmailId(String emailId);
}
