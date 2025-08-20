package com.baithak.assignment.controller;

import com.baithak.assignment.dto.AssignmentDto;
import com.baithak.assignment.dto.PlaceOverviewDto;
import com.baithak.assignment.service.impl.AssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    // show last 10 locations
    @GetMapping("/v1/person/{id}/history")
    public ResponseEntity<List<AssignmentDto>> getHistory(@PathVariable Long id) {
        log.info("Fetching last 10 history records for personId={}", id);
        return ResponseEntity.ok(assignmentService.getLast10Meetings(id));
    }

    // manually assign new location
    @PostMapping("/v1/person/{id}/assign")
    public ResponseEntity<AssignmentDto> assignMeeting(
            @PathVariable Long id,
            @RequestParam Long placeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("Assigning new meeting for personId={} placeId={} date={}", id, placeId, date);
        return ResponseEntity.ok(assignmentService.assignMeeting(id, placeId, date));
    }

    @GetMapping("/v1/overview")
    public ResponseEntity<List<PlaceOverviewDto>> getOverview() {
        return ResponseEntity.ok(assignmentService.getPlacesOverview());
    }
}
