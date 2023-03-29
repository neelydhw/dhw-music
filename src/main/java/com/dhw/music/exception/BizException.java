package com.dhw.music.exception;

import com.dhw.music.enums.ExceptionType;

/**
 * @author Neely
 * @date 2023/3/29
 */
public class BizException extends RuntimeException{
    private final Integer code;

    public Integer getCode() {
        return code;
    }

    public BizException(ExceptionType exceptionType){
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }
}
