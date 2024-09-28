package com.project.mobileStore.services;

import com.project.mobileStore.dto.UserRegistrationDto;
import com.project.mobileStore.models.User;

public interface UserService {
    User save(UserRegistrationDto RegistrationDto);
}
