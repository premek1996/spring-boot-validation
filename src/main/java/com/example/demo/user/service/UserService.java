package com.example.demo.user.service;

import com.example.demo.user.controller.dto.CreateUserRequest;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(CreateUserRequest createUserRequest) {
        return userRepository.save(createUserRequest.toUser());
    }
}
