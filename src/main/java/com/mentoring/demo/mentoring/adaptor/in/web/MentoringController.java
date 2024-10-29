package com.mentoring.demo.mentoring.adaptor.in.web;

import com.mentoring.demo.mentoring.adaptor.in.kafka.KafkaProducer;
import com.mentoring.demo.mentoring.adaptor.in.web.mapper.MentoringVoMapper;
import com.mentoring.demo.mentoring.adaptor.in.web.vo.MentoringAddRequestVo;
import com.mentoring.demo.mentoring.application.port.in.MentoringUseCase;
import com.mentoring.demo.mentoring.application.port.in.dto.MentoringAddRequestDto;
import com.mentoring.demo.mentoring.common.entity.BaseResponse;
import com.mentoring.demo.mentoring.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentoring")
public class MentoringController {
    private final MentoringUseCase mentoringUseCase;
    private final KafkaProducer kafkaProducer;

    @Operation(summary = "멘토링 생성")
    @PostMapping("")
    public BaseResponse<Void> singUp(@RequestBody MentoringAddRequestVo request) {
        MentoringAddRequestDto createMentoringDto = MentoringVoMapper.toCreateMentoringDto(request);
        // 멘토링 생성
        mentoringUseCase.createMentoring(createMentoringDto);
        // 멘토링 생성 이벤트 발생
        kafkaProducer.sendCreateMentoring("create-mentoring", createMentoringDto);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    // todo : 멘토링 수정

    // todo : 멘토링 삭제
}