package com.dhw.music.vo;

import com.dhw.music.enums.Gender;
import lombok.Data;

import java.util.List;

/**
 * 用户VO
 *
 * @author Neely
 * @date 2023/3/24
 */
@Data
public class UserVo {
    private String id;
    private String username;
    private String nickname;
    private Gender gender;
    private Boolean locked;
    private Boolean enabled;

    private List<RoleVo> roles;
}
