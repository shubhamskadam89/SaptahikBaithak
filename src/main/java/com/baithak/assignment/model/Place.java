package com.baithak.assignment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Place")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlaceType type; // male / female

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MeetingDay meetingDay;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "time_slot")   // ✅ fix: map enum to SQL column
    private TimeSlot timeSlot;

    public enum PlaceType {
        MALE, FEMALE
    }


}
