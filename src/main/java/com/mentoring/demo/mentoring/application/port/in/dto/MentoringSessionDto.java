package com.mentoring.demo.mentoring.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class MentoringSessionDto{
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDateTime deadline_datetime;

    private Integer minHeadCount;
    private Integer maxHeadCount;
    private Integer price;

    @Builder
    public MentoringSessionDto(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime,
                               LocalDateTime deadline_datetime, Integer minHeadCount, Integer maxHeadCount, Integer price) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deadline_datetime = deadline_datetime;
        this.minHeadCount = minHeadCount;
        this.maxHeadCount = maxHeadCount;
        this.price = price;
    }


}
