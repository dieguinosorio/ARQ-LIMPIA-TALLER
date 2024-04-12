package com.cleanone.clean_one.domain.usecase.impl;

import com.cleanone.clean_one.domain.model.User;
import com.cleanone.clean_one.domain.usecase.CreateUserUseCase;
import com.cleanone.clean_one.infraestructure.drivenadapters.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    @Autowired
    public CreateUserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(String name, String email, String password) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }
}