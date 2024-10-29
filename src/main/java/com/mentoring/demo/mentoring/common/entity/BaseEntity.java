package com.mentoring.demo.mentoring.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt; // 최초 생성일

    private LocalDateTime updatedAt; // 마지막 수정일
    @PrePersist // 저장 전에 동작
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }
    @PreUpdate // 업데이트 전에 동작
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}