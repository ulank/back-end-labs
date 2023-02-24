package com.example.introback.service;

import com.example.introback.entity.User;
import com.example.introback.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ulan on 2/24/2023
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
