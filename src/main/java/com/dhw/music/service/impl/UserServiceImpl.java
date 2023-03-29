package com.dhw.music.service.impl;

import com.dhw.music.dto.UserCreateDto;
import com.dhw.music.dto.UserDto;
import com.dhw.music.entity.User;
import com.dhw.music.enums.ExceptionType;
import com.dhw.music.exception.BizException;
import com.dhw.music.mapper.UserMapper;
import com.dhw.music.repository.UserRepository;
import com.dhw.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Neely
 * @date 2023/3/24
 */
@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    UserMapper mapper;



    PasswordEncoder passwordEncoder;



    @Override
    public List<UserDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        checkUserName(userCreateDto.getUsername());
        User user = mapper.createEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(user));
    }

    @Override
    public User loadUserByUsername(String username) {
        Optional<User> user = repository.findByUsername(username);
        if(!user.isPresent()){
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }


    private void checkUserName(String username){
        Optional<User> user = repository.findByUsername(username);
        if(user.isPresent()){
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }
    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
