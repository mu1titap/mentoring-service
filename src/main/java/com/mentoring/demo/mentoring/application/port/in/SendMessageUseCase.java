package com.mentoring.demo.mentoring.application.port.in;

import com.mentoring.demo.mentoring.application.port.in.dto.MentoringAddRequestDto;
import com.mentoring.demo.mentoring.application.port.out.dto.MentoringAddAfterOutDto;
import com.mentoring.demo.mentoring.application.port.out.dto.MentoringSessionOutDto;

import java.util.List;

public interface SendMessageUseCase {
    void sendCreateMentoringMessage(String topic , MentoringAddAfterOutDto mentoringAddAfterOutDto);

}