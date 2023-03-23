package com.dhw.music.repository;

import com.dhw.music.entity.User;
import com.dhw.music.enums.Gender;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Neely
 * @date 2023/3/24
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
}