package com.dhw.music.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dhw.music.config.SecurityConfig;
import com.dhw.music.dto.TokenCreateRequest;
import com.dhw.music.dto.UserCreateRequest;
import com.dhw.music.dto.UserDto;
import com.dhw.music.dto.UserUpdateRequest;
import com.dhw.music.entity.User;
import com.dhw.music.enums.ExceptionType;
import com.dhw.music.exception.BizException;
import com.dhw.music.mapper.UserMapper;
import com.dhw.music.repository.UserRepository;
import com.dhw.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author Neely
 * @date 2023/3/24
 */
@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    UserMapper mapper;


    PasswordEncoder passwordEncoder;


//    @Override
//    public List<UserDto> list() {
//        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
//    }


    @Override
    public Page<UserDto> search(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }


    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUserName(userCreateRequest.getUsername());
        User user = mapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(user));
    }

    @Override
    public UserDto get(String id) {
        Optional<User> userOpt = repository.findById(id);
        if (!userOpt.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return mapper.toDto(userOpt.get());
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
        Optional<User> userOpt = repository.findById(id);
        if (!userOpt.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return mapper.toDto(repository.save(mapper.updateEntity(userOpt.get(), userUpdateRequest)));
    }

    @Override
    public void delete(String id) {
        //Todo: 重构
        Optional<User> userOpt = repository.findById(id);
        if (!userOpt.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        repository.delete(userOpt.get());
    }

    @Override
    public User loadUserByUsername(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        User user = loadUserByUsername(tokenCreateRequest.getUsername());
        if (!passwordEncoder.matches(tokenCreateRequest.getPassword(), user.getPassword())) {
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
        if (!user.isEnabled()) {
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }
        if (!user.isAccountNonLocked()) {
            throw new BizException(ExceptionType.USER_LOCKED);
        }
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET));
    }

    @Override
    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = loadUserByUsername(authentication.getName());
        return mapper.toDto(currentUser);
    }


    private void checkUserName(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }

    @Autowired
    private void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
