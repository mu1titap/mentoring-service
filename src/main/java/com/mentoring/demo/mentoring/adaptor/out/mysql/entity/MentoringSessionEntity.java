package com.mentoring.demo.mentoring.adaptor.out.mysql.entity;

import com.mentoring.demo.mentoring.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity(name = "mentoring_session")
public class MentoringSessionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid")
    @Comment("세션 UUID")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "mentoring_id") // FK 관계설정
    @Comment("멘토링 ID")
    private MentoringEntity mentoringEntity;

    @Column(name = "start_date")
    @Comment("시작 날짜")
    private LocalDate startDate;

    @Column(name = "end_date")
    @Comment("종료 날짜")
    private LocalDate endDate;

    @Column(name = "start_time")
    @Comment("시작 시간")
    private LocalTime startTime;

    @Column(name = "end_time")
    @Comment("종료 시간")
    private LocalTime endTime;

    @Column(name = "deadline_datetime")
    @Comment("예약 마감 날짜")
    private LocalDateTime deadlineDatetime;

    @Column(name = "min_head_count")
    @Comment("최소 인원")
    private Integer minHeadCount;

    @Column(name = "max_head_count")
    @Comment("최대 인원")
    private Integer maxHeadCount;

    @Column(name = "price")
    @Comment("볼트")
    private Integer price;

    @Column(name = "isClosed" , nullable = false)
    @Comment("마감 여부")
    private Boolean isClosed;

    @Builder
    public MentoringSessionEntity(String uuid, MentoringEntity mentoringEntity,
                                  LocalDate startDate, LocalDate endDate,
                                  LocalTime startTime, LocalTime endTime, LocalDateTime deadlineDatetime,
                                  Integer minHeadCount, Integer maxHeadCount, Integer price, Boolean isClosed) {
        this.uuid = uuid;
        this.mentoringEntity = mentoringEntity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deadlineDatetime = deadlineDatetime;
        this.minHeadCount = minHeadCount;
        this.maxHeadCount = maxHeadCount;
        this.price = price;
        this.isClosed = isClosed;
    }
}