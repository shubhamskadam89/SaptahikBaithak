package com.baithak.assignment.dto;

import com.baithak.assignment.model.Gender;
import com.baithak.assignment.model.MeetingDay;
import com.baithak.assignment.model.TimeSlot;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceDetailDto {
    private Long placeId;
    private String name;
    private Gender type;
    private MeetingDay meetingDay;
    private TimeSlot timeSlot;
}
