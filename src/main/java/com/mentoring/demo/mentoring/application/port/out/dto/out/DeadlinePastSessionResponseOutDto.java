package com.mentoring.demo.mentoring.application.port.out.dto.out;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeadlinePastSessionResponseOutDto {
    private Long sessionId;
    private String sessionUuid;
    private Integer minHeadCount;
    private Integer maxHeadCount;
    private LocalDate startDate;



}