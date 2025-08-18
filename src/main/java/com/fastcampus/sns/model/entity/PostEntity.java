package com.fastcampus.sns.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "\"post\"")
@Entity
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "registered_at")
    private Timestamp registeredAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt() {
        this.registeredAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    @LastModifiedDate
    void deletedAt() {
        if (this.id != null && this.deletedAt == null) {
            this.deletedAt = Timestamp.from(Instant.now());
        }
    }

    public static PostEntity of(String title, String body, UserEntity userEntity) {
        return PostEntity.builder()
                .title(title)
                .body(body)
                .user(userEntity)
                .build();
    }

}
