package com.mentoring.demo.mentoring.adaptor.out.mysql.mapper;

import com.mentoring.demo.mentoring.adaptor.out.mysql.entity.MentoringCategoryEntity;
import com.mentoring.demo.mentoring.adaptor.out.mysql.entity.MentoringEntity;
import com.mentoring.demo.mentoring.adaptor.out.mysql.entity.MentoringHashTagEntity;
import com.mentoring.demo.mentoring.adaptor.out.mysql.entity.MentoringSessionEntity;
import com.mentoring.demo.mentoring.application.port.out.dto.in.*;
import com.mentoring.demo.mentoring.application.port.out.dto.out.MentoringAddAfterOutDto;
import com.mentoring.demo.mentoring.application.port.out.dto.out.MentoringCategoryAfterOutDto;
import com.mentoring.demo.mentoring.application.port.out.dto.out.MentoringSessionAddAfterOutDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class mentoringEntityMapper {

    // MentoringEditTransactionDto -> MentoringEntity
    public static MentoringEntity from( MentoringEditRequestOutDto dto) {
        return MentoringEntity.builder()
                .id(Long.valueOf(dto.getId()))
                .mentoringUuid(dto.getUuid())
                .mentorUuid(dto.getMentorUuid())
                .name(dto.getName())
                .description(dto.getDescription())
                .detail(dto.getDetail())
                .thumbnailUrl(dto.getThumbnailUrl())
                .isReusable(dto.getIsReusable())
                .isDeleted(dto.getIsDeleted())
                .build();
    }
    //



    public static MentoringResponseOutDto toMentoringResponseOutDto(MentoringEntity entity) {
        return MentoringResponseOutDto.builder()
                .id(entity.getId().toString())
                .uuid(entity.getMentoringUuid())
                .mentorUuid(entity.getMentorUuid())
                .name(entity.getName())
                .detail(entity.getDetail())
                .thumbnailUrl(entity.getThumbnailUrl())
                .isReusable(entity.getIsReusable())
                .isDeleted(entity.getIsDeleted())
                .build();
    }

    public static MentoringAddAfterOutDto from(MentoringEntity entity) {
        return MentoringAddAfterOutDto.builder()
                .mentoringId(entity.getId().toString())
                .mentoringUuid(entity.getMentoringUuid())
                .mentorUuid(entity.getMentorUuid())
                .name(entity.getName())
                .description(entity.getDescription())
                .detail(entity.getDetail())
                .thumbnailUrl(entity.getThumbnailUrl())
                .isReusable(entity.getIsReusable())
                .isDeleted(entity.getIsDeleted())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
    public static List<MentoringSessionAddAfterOutDto> from(
                                                     List<MentoringSessionEntity> mentoringSessionEntities
    ) {
        return mentoringSessionEntities.stream()
                .map(session -> MentoringSessionAddAfterOutDto.builder()
                        .sessionId(session.getId().toString())
                        .sessionUuid(session.getUuid())
                        .mentoringId(session.getMentoringEntity().getId().toString())
                        .mentoringUuid(session.getMentoringEntity().getMentoringUuid())
                        .startDate(session.getStartDate())
                        .endDate(session.getEndDate())
                        .startTime(session.getStartTime())
                        .endTime(session.getEndTime())
                        .deadlineDate(session.getDeadlineDate())
                        .minHeadCount(session.getMinHeadCount())
                        .maxHeadCount(session.getMaxHeadCount())
                        .price(session.getPrice())
                        .isClosed(session.getIsClosed())
                        .isDeleted(session.getIsDeleted())
                        .createdAt(session.getCreatedAt())
                        .updatedAt(session.getUpdatedAt())
                        .build())
                .toList();
    }

    /**
     * 카테고리
     */
    public static List<MentoringCategoryAfterOutDto> toMentoringCategoryAfterOutDto(
            List<MentoringCategoryEntity> categoryEntities,
            List<MentoringCategoryOutDto> mentoringAddRequestOutDtos
    ) {
        return IntStream.range(0, categoryEntities.size())
                .mapToObj(i -> {
                    MentoringCategoryEntity categoryEntity = categoryEntities.get(i);
                    MentoringCategoryOutDto requestDto = mentoringAddRequestOutDtos.get(i);

                    return MentoringCategoryAfterOutDto.builder()
                            .id(categoryEntity.getId().toString())
                            .mentoringUuid(requestDto.getMentoringUuid())
                            .topCategoryCode(requestDto.getTopCategoryCode())
                            .middleCategoryCode(requestDto.getMiddleCategoryCode())
                            .bottomCategoryCode(requestDto.getBottomCategoryCode())
                            .topCategoryName(requestDto.getTopCategoryName())
                            .middleCategoryName(requestDto.getMiddleCategoryName())
                            .bottomCategoryName(requestDto.getBottomCategoryName())
                            .createdAt(categoryEntity.getCreatedAt())
                            .updatedAt(categoryEntity.getUpdatedAt())
                            .build();
                })
                .collect(Collectors.toList());
    }

    public static List<MentoringCategoryAfterOutDto> of(
            List<MentoringCategoryEntity> entities, List<MentoringCategoryAfterOutDto> categoryAfterOutDtos
    ) {
        return entities != null ? IntStream.range(0, entities.size())
                .mapToObj(i -> {
                    MentoringCategoryEntity categoryEntity = entities.get(i);
                    MentoringCategoryAfterOutDto afterOutDto = categoryAfterOutDtos.get(i);

                    return MentoringCategoryAfterOutDto.builder()
                            .id(categoryEntity.getId().toString())
                            .mentoringUuid(afterOutDto.getMentoringUuid())
                            .topCategoryCode(afterOutDto.getTopCategoryCode())
                            .middleCategoryCode(afterOutDto.getMiddleCategoryCode())
                            .bottomCategoryCode(afterOutDto.getBottomCategoryCode())
                            .topCategoryName(afterOutDto.getTopCategoryName())
                            .middleCategoryName(afterOutDto.getMiddleCategoryName())
                            .bottomCategoryName(afterOutDto.getBottomCategoryName())
                            .createdAt(categoryEntity.getCreatedAt())
                            .updatedAt(categoryEntity.getUpdatedAt())
                            .build();
                })
                .collect(Collectors.toList()) :  null;
    }


}
