package com.baithak.assignment.dto;

import com.baithak.assignment.entity.Days;
import com.baithak.assignment.entity.Members;
import com.baithak.assignment.entity.Places;
import lombok.Data;

import java.util.Date;

@Data
public class AssignmentHistory {


    private Long id;

    private String memberName;

    private String placeName;

    private String day;

    private String date;

}
