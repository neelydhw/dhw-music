package com.dhw.music.exception;

import lombok.Data;

/**
 * @author Neely
 * @date 2023/3/29
 */
@Data
public class ErrorResponse {
    private Integer code;
    private String message;
    private Object trace;
}
