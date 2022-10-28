package com.example.demo.user.service;

import com.example.demo.user.controller.dto.CreateUserDTO;
import com.example.demo.user.controller.dto.UserResponseDTO;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO createUser(CreateUserDTO createUserDTO) {
        var addedUser = userRepository.save(createUserDTO.toUser());
        return UserResponseDTO.of(addedUser);
    }

}
