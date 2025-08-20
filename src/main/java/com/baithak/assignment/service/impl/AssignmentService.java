package com.baithak.assignment.service.impl;

import com.baithak.assignment.dto.AssignmentDto;
import com.baithak.assignment.dto.PlaceOverviewDto;
import com.baithak.assignment.model.Person;
import com.baithak.assignment.model.PersonAssignment;
import com.baithak.assignment.model.Place;
import com.baithak.assignment.repository.PersonAssignmentRepository;
import com.baithak.assignment.repository.PersonRepository;
import com.baithak.assignment.repository.PlacesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssignmentService {

    private final PersonAssignmentRepository assignmentRepo;
    private final PersonRepository personRepo;
    private final PlacesRepository placesRepo;

    /**
     * Get last 10 meetings for a person as DTOs (avoids Hibernate proxy issues)
     */
    public List<AssignmentDto> getLast10Meetings(Long personId) {
        log.info("Fetching last 10 meetings for personId={}", personId);

        return assignmentRepo.findRecentMeetings(personId, PageRequest.of(0, 10))
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Assign a new meeting and return as DTO
     */
    public AssignmentDto assignMeeting(Long personId, Long placeId, LocalDate date) {
        log.info("Assigning meeting for personId={} at placeId={} on {}", personId, placeId, date);

        Person person = personRepo.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
        Place place = placesRepo.findById(placeId)
                .orElseThrow(() -> new IllegalArgumentException("Place not found"));

        PersonAssignment assignment = PersonAssignment.builder()
                .person(person)
                .place(place)
                .meetingDate(date)
                .meetingDay(date.getDayOfWeek().toString())
                .createdAt(LocalDateTime.now())
                .build();

        PersonAssignment saved = assignmentRepo.save(assignment);
        return toDto(saved);
    }

    /**
     * Mapping entity -> DTO
     */
    private AssignmentDto toDto(PersonAssignment assignment) {
        return AssignmentDto.builder()
                .assignmentId(assignment.getAssignmentId())
                .personId(assignment.getPerson().getPersonId())
                .personName(assignment.getPerson().getName())
                .timeSlot(assignment.getPlace().getTimeSlot().toString())
                .placeId(assignment.getPlace().getPlaceId())
                .placeName(assignment.getPlace().getName())
                .meetingDate(assignment.getMeetingDate())
                .meetingDay(assignment.getMeetingDay())
                .createdAt(assignment.getCreatedAt())
                .build();
    }

    public List<PlaceOverviewDto> getPlacesOverview() {
        List<Place> allPlaces = placesRepo.findAll();

        return allPlaces.stream().map(place -> {
            // check if this place has a latest assignment
            PersonAssignment latest = assignmentRepo
                    .findTopByPlaceOrderByMeetingDateDesc(place)
                    .orElse(null);

            return PlaceOverviewDto.builder()
                    .placeId(place.getPlaceId())
                    .placeName(place.getName())
                    .meetingDay(place.getMeetingDay().toString())
                    .timeSlot(place.getTimeSlot().toString())
                    .meetingDate(latest != null ? latest.getMeetingDate() : null)
                    .personId(latest != null ? latest.getPerson().getPersonId() : null)
                    .personName(latest != null ? latest.getPerson().getName() : null)
                    .build();
        }).toList();
    }

}
