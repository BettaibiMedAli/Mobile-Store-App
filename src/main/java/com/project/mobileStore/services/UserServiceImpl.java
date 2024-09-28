package com.project.mobileStore.services;

import com.project.mobileStore.dto.UserRegistrationDto;
import com.project.mobileStore.models.Role;
import com.project.mobileStore.models.User;
import com.project.mobileStore.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;
    public UserServiceImpl(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),
                registrationDto.getEmail(),registrationDto.getPassword(), Arrays.asList(new Role("ROLE-USER")));
        return userRepo.save(user);
    }
}
