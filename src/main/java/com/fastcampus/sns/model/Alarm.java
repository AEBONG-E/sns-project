package com.fastcampus.sns.model;

import com.fastcampus.sns.model.entity.AlarmEntity;
import lombok.*;

import java.sql.Timestamp;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Alarm {

    private Integer id;
    private AlarmType alarmType;
    private AlarmArgs args;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static Alarm fromEntity(AlarmEntity alarmEntity) {
        return Alarm.builder()
                .id(alarmEntity.getId())
                .alarmType(alarmEntity.getAlarmType())
                .args(alarmEntity.getArgs())
                .registeredAt(alarmEntity.getRegisteredAt())
                .updatedAt(alarmEntity.getUpdatedAt())
                .deletedAt(alarmEntity.getDeletedAt())
                .build();
    }

}
