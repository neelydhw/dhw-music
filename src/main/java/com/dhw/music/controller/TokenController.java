package com.dhw.music.controller;

import com.dhw.music.dto.TokenCreateRequest;
import com.dhw.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Neely
 * @date 2023/4/10
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    UserService userService;

    @PostMapping
    public String create(@RequestBody TokenCreateRequest tokenCreateRequest) {
        return userService.createToken(tokenCreateRequest);
    }


}
