package com.dhw.music.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Neely
 * @date 2023/4/10
 */
@Data
public class TokenCreateRequest {
    @NotBlank(message = "用户不能为空")
    @Size(min = 4, max = 64, message = "用户名长度应该在4个字符到64个字符之间")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 64, message = "密码长度应该在6个字符到64个字符之间")
    private String password;
}
