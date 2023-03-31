package com.dhw.music.mapper;


import com.dhw.music.dto.UserCreateRequest;
import com.dhw.music.dto.UserDto;
import com.dhw.music.dto.UserUpdateRequest;
import com.dhw.music.entity.User;
import com.dhw.music.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * @author Neely
 * @date 2023/3/24
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);


    User updateEntity(@MappingTarget User user, UserUpdateRequest updateRequest);
}
