package com.dhw.music.dto;

import com.dhw.music.enums.Gender;
import com.dhw.music.vo.RoleVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Neely
 * @date 2023/3/24
 */
@Data
public class UserDto {
    private String id;
    private String username;
    private String nickname;
    private List<RoleVo> roles;
    private Gender gender;
    private Boolean locked = false;
    private Boolean enabled = true;
    private String lastLoginIp;
    private Date lastLoginTime;
}
