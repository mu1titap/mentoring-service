package com.mentoring.demo.mentoring.application.service;

import com.mentoring.demo.mentoring.application.mapper.MentoringDtoMapper;
import com.mentoring.demo.mentoring.application.port.in.dto.MentoringAddRequestDto;
import com.mentoring.demo.mentoring.application.port.in.MentoringUseCase;
import com.mentoring.demo.mentoring.application.port.out.MentoringRepositoryOutPort;
import com.mentoring.demo.mentoring.application.port.out.dto.MentoringSessionTransactionDto;
import com.mentoring.demo.mentoring.application.port.out.dto.MentoringTransactionDto;
import com.mentoring.demo.mentoring.domain.model.MentoringDomain;
import com.mentoring.demo.mentoring.domain.model.MentoringSessionDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class MentoringService implements MentoringUseCase {
    private final MentoringRepositoryOutPort mentoringRepositoryOutPort;


    // 멘토링세션아웃포트 생성
    @Override
    public void createMentoring(MentoringAddRequestDto mentoringAddRequestDto) {

        MentoringDomain mentoring = MentoringDomain.createMentoring(mentoringAddRequestDto);
        // 멘토링 도메인 -> 멘토링 트랜잭션 DTO 변환
        MentoringTransactionDto mentoringTransactionDto = MentoringDtoMapper.toMentoringTransactionDto(mentoring);

        // 멘토링 세션
        List<MentoringSessionDomain> sessionDomain =
                MentoringSessionDomain.createMentoringSession(mentoringAddRequestDto);

        List<MentoringSessionTransactionDto> sessionTransactionDto =
                MentoringDtoMapper.toSessionTransactionDto(mentoring, sessionDomain);
        mentoringTransactionDto.setSessionList(sessionTransactionDto);


        mentoringRepositoryOutPort.createMentoring(mentoringTransactionDto);

    }
}