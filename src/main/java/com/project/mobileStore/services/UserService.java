package com.project.mobileStore.services;

import com.project.mobileStore.dto.UserRegistrationDto;
import com.project.mobileStore.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto RegistrationDto);
}
