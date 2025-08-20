package com.baithak.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDto {
    private Long assignmentId;

    private Long personId;
    private String personName;

    private Long placeId;
    private String placeName;

    private LocalDate meetingDate;
    private String meetingDay;
    private String timeSlot;

    private LocalDateTime createdAt;
}
