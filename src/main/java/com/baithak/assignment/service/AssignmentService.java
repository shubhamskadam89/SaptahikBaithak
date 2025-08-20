package com.baithak.assignment.service;

import com.baithak.assignment.dto.AssignmentResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AssignmentService {

    void assignWeeklyBaithaks();

    List<AssignmentResponseDto> assignFivePlaces();

    AssignmentResponseDto assignManually(String placeName, String personName, String dayOfWeek);

}
