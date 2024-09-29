package com.jobhunt.api.service;

import com.jobhunt.api.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User newUser(User user);
    public User updateUser(User user);
    public User deleteUserById(Long id);
    public User findByUserEmailId(String emailId);
}
