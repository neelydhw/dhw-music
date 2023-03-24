package com.dhw.music.service;

import com.dhw.music.dto.UserDto;
import com.dhw.music.mapper.UserMapper;
import com.dhw.music.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Neely
 * @date 2023/3/24
 */
@Service
public class UserServiceImpl implements UserService{



    UserRepository repository;



    UserMapper mapper;
    @Override
    public List<UserDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
