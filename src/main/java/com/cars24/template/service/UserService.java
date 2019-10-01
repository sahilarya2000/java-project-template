package com.cars24.template.service;

import com.cars24.template.dto.UserDto;
import com.cars24.template.entity.UserEntity;


public interface UserService {

    UserEntity save(UserDto userDto);

    UserDto getUser(Long userId);
}
