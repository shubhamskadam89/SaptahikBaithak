package com.baithak.assignment.entity;


import jakarta.persistence.Entity;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class Places {

    private Long placeId;

    private String placeName;

    private Boolean unisex;

    private Days day;

    private TimeSlot time;

}
