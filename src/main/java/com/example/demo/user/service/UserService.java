package com.example.demo.user.service;

import com.example.demo.user.controller.dto.CreateUserRequest;
import com.example.demo.user.controller.dto.UserResponse;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(CreateUserRequest createUserRequest) {
        var addedUser = userRepository.save(createUserRequest.toUser());
        return UserResponse.of(addedUser);
    }

}
