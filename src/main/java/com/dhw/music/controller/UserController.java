package com.dhw.music.controller;

import com.dhw.music.dto.UserCreateRequest;
import com.dhw.music.dto.UserUpdateRequest;
import com.dhw.music.mapper.UserMapper;
import com.dhw.music.service.UserService;
import com.dhw.music.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口类
 *
 * @author Neely
 * @date 2023/3/24
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
@Api(tags = "用户管理")
public class UserController {
    UserService userService;
    UserMapper userMapper;


    @GetMapping
    @ApiOperation("用户检索")
    Page<UserVo> search(@PageableDefault(sort = {"createdTime"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.search(pageable).map(userMapper::toVo);
    }

    @PostMapping
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVo(userService.create(userCreateRequest));
    }

    @GetMapping("/{id}")
    UserVo get(@PathVariable String id) {
        return userMapper.toVo(userService.get(id));
    }

    @PutMapping("{id}")
    UserVo update(@PathVariable String id, @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVo(userService.update(id, userUpdateRequest));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @GetMapping("/me")
    UserVo me() {
        return userMapper.toVo(userService.getCurrentUser());
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
