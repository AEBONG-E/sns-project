package com.fastcampus.sns.model;

import com.fastcampus.sns.model.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private UserRole userRole;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static User fromEntity(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .username(userEntity.getUserName())
                .password(userEntity.getPassword())
                .userRole(userEntity.getRole())
                .registeredAt(userEntity.getRegisteredAt())
                .updatedAt(userEntity.getUpdatedAt())
                .deletedAt(userEntity.getDeletedAt())
                .build();
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.userRole.toString()));
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return this.deletedAt == null;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return this.deletedAt == null;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return this.deletedAt == null;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return this.deletedAt == null;
    }
}
