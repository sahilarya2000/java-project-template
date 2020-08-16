package com.practice.template.service;

import com.practice.template.dto.UserDto;
import com.practice.template.entity.UserEntity;


public interface UserService {

    UserEntity save(UserDto userDto);

    UserDto getUser(Long userId);
}
