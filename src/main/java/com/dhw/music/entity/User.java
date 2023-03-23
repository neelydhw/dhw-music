package com.dhw.music.entity;

import com.dhw.music.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 用户实体
 * @author Neely
 * @date 2023/3/24
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends AbstractEntity{
    @Column(unique = true)
    private String username;
    private String nickname;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roles;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Boolean locked;
    private Boolean enabled;
    private String lastLoginIp;
    private Date lastLoginTime;

}
