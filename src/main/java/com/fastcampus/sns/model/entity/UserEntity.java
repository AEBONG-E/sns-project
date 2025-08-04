package com.fastcampus.sns.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
@Entity
public class UserEntity {

    @Id
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;

    @Builder
    public UserEntity(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
