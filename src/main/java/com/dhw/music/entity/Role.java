package com.dhw.music.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * 角色实体
 * @author Neely
 * @date 2023/3/24
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Serialization
public class Role extends AbstractEntity{
    private String name;
    private String title;
}
