package com.dhw.music.dto;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

/**
 * @author Neely
 * @date 2023/3/24
 */
@Data
@Serialization
public class RoleDto {
    private String id;
    private String name;
    private String title;
}
