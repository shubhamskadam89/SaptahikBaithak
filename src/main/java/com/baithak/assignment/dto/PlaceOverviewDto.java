package com.baithak.assignment.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOverviewDto {
    private Long placeId;
    private String placeName;
    private String meetingDay;
    private String timeSlot;

    private LocalDate meetingDate;
    private Long personId;
    private String personName;
}
