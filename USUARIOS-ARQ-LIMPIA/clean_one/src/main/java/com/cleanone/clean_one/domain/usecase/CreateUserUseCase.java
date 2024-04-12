package com.cleanone.clean_one.domain.usecase;

import com.cleanone.clean_one.domain.model.User;

public interface CreateUserUseCase {
    User execute(String name, String email, String password);
}

