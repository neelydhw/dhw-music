package com.dhw.music.dto;

import com.dhw.music.vo.RoleVo;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

import java.util.List;

/**
 * @author Neely
 * @date 2023/3/24
 */
@Data
@Serialization
public class UserDto {
    private String id;
    private String username;
    private String nickname;

    private List<RoleVo> roles;
}
