package com.practice.template.service.impl;


import com.practice.template.dto.UserDto;
import com.practice.template.entity.UserEntity;
import com.practice.template.repository.UserRepository;
import com.practice.template.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity save(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        return userRepository.save(userEntity);
    }

    @Override
    public UserDto getUser(Long userId) {
        UserEntity userEntity = new UserEntity();
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if (userEntityOptional.isPresent())
            userEntity = userEntityOptional.get();
        return mapEntityToDto(userEntity);
    }

    private UserDto mapEntityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        return userDto;
    }
}
