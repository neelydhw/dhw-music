package com.dhw.music.controller;

import com.dhw.music.dto.UserDto;
import com.dhw.music.entity.User;
import com.dhw.music.mapper.UserMapper;
import com.dhw.music.service.UserService;
import com.dhw.music.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 用户接口类
 * @author Neely
 * @date 2023/3/24
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    UserService userService;
    UserMapper userMapper;



    @GetMapping("/")
    List<UserVo> list(){
        return userService.list().stream().map(userMapper::toVo).collect(Collectors.toList());
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
