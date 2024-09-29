package com.jobhunt.api.service;

import com.jobhunt.api.entity.User;
import com.jobhunt.api.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id){
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new RuntimeException("User not present");
    }

    @Override
    public User newUser(User user){
        User usr = userRepository.save(user);
        log.info("new user saved");
        return usr;
    }

    @Override
    public User updateUser(User user){
        Optional<User> optional = userRepository.findById(user.getUserId());
        if (optional.isPresent()){
            log.info("user updated");
            return userRepository.save(user);
        }
        throw new RuntimeException("User "+user.getUserId()+"not update");
    }

    @Override
    public User deleteUserById(Long id){
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()){
            userRepository.deleteById(id);
            return null;
        }
        throw new RuntimeException("User not deleted");
    }

    @Override
    public User findByUserEmailId(String emailId){
        Optional<User> optional = Optional.ofNullable(userRepository.findByEmailId(emailId));
        if (optional.isPresent()){
            return optional.get();
        }
        throw new RuntimeException("EmailId not matched");
    }

}

