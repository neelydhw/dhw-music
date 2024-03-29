package com.dhw.music.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Neely
 * @date 2023/3/31
 */
@Data
public class UserUpdateRequest {
    @NotBlank(message = "用户不能为空")
    @Size(min = 4, max = 64, message = "用户名长度应该在4个字符到64个字符之间")
    private String username;
    private String nickname;
    private String gender;
}
