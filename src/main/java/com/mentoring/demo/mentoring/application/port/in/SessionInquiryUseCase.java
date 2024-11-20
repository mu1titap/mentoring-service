package com.mentoring.demo.mentoring.application.port.in;


import com.mentoring.demo.mentoring.application.port.out.dto.out.DeadlinePastSessionResponseOutDto;

import java.util.List;

public interface SessionInquiryUseCase {

    List <DeadlinePastSessionResponseOutDto> getPastDeadlineSessions();
}