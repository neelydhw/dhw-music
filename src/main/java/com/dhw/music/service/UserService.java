package com.dhw.music.service;

import com.dhw.music.dto.TokenCreateRequest;
import com.dhw.music.dto.UserCreateRequest;
import com.dhw.music.dto.UserDto;
import com.dhw.music.dto.UserUpdateRequest;
import com.dhw.music.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Neely
 * @date 2023/3/24
 */

public interface UserService extends UserDetailsService {
//    List<UserDto> list();

    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);


    String createToken(TokenCreateRequest tokenCreateRequest);

    UserDto getCurrentUser();
}
