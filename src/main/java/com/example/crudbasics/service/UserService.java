package com.example.crudbasics.service;

import com.example.crudbasics.dto.UserDto;
import com.example.crudbasics.models.User;

public interface UserService {
    User register(UserDto userDto);
    String login(UserDto userDto);
}
