package com.dhw.music.service;

import com.dhw.music.dto.UserCreateDto;
import com.dhw.music.dto.UserDto;
import com.dhw.music.entity.User;
import com.dhw.music.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author Neely
 * @date 2023/3/24
 */

public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);

    @Override
    User loadUserByUsername(String username);
}
