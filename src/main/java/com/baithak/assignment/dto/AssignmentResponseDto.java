package com.baithak.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AssignmentResponseDto {


    private Long id;

    private String memberName;

    private String placeName;

    private String day;

    private String date;



}
