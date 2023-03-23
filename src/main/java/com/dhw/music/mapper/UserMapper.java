package com.dhw.music.mapper;

import com.dhw.music.dto.UserDto;
import com.dhw.music.entity.User;
import com.dhw.music.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Neely
 * @date 2023/3/24
 */
@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);
}
