package com.fastcampus.sns.model;

import com.fastcampus.sns.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

// TODO : implement
@Getter
@Builder
@AllArgsConstructor
public class User implements UserDetails {

    private Integer id;
    private String userName;
    private String password;
    private UserRole userRole;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static User fromEntity(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .userRole(userEntity.getRole())
                .registeredAt(userEntity.getRegisteredAt())
                .updatedAt(userEntity.getUpdatedAt())
                .deletedAt(userEntity.getDeletedAt())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.userRole.toString()));
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.deletedAt == null;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.deletedAt == null;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.deletedAt == null;
    }

    @Override
    public boolean isEnabled() {
        return this.deletedAt == null;
    }
}
