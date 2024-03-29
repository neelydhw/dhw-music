package com.dhw.music.entity;

import com.dhw.music.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
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
public class User extends AbstractEntity implements UserDetails {
    @Column(unique = true)
    private String username;
    private String nickname;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roles;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Boolean locked = false;
    private Boolean enabled = true;
    private String lastLoginIp;
    private Date lastLoginTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getEnabled();
    }
}
