package com.practice.template.controller;

import com.practice.template.dto.UserDto;
import com.practice.template.response.MessageResponseEntity;
import com.practice.template.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public MessageResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto userDto) {
        log.info("request to add user {} ", userDto);
        try {
            return new MessageResponseEntity(userService.save(userDto), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("error while adding user");
            return new MessageResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "error");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public MessageResponseEntity<UserDto> getUser(@RequestParam(name = "userId") Long userId) {
        log.info("request to get user with Id {} ", userId);
        try {
            return new MessageResponseEntity<>(userService.getUser(userId),HttpStatus.OK);
        } catch (Exception e) {
            log.error("error while adding user");
            return new MessageResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "error");
        }
    }
}
