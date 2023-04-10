package com.dhw.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class DhwMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhwMusicApplication.class, args);
    }

}
