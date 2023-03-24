package com.dhw.music.service;

import com.dhw.music.dto.UserDto;

import java.util.List;

/**
 * @author Neely
 * @date 2023/3/24
 */

public interface UserService {
    List<UserDto> list();
}
