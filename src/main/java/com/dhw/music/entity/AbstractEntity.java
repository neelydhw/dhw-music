package com.dhw.music.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 实体基类
 * @author Neely
 * @date 2023/3/24
 */
@MappedSuperclass
@Data
@Serialization
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(generator = "ksuid")
    @GenericGenerator(name="ksuid",strategy = "com.dhw.music.utils.KsuidIdentifierGenerator")
    private String id;
    @CreationTimestamp
    private Date createdTime;
    @UpdateTimestamp
    private Date updatedTime;
}
