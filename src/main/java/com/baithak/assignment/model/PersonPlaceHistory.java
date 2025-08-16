package com.baithak.assignment.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Person_Place_History")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(PersonPlaceHistoryId.class)
public class PersonPlaceHistory {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @Column(nullable = false)
    private Integer lastYear;

    @Column(nullable = false)
    private Integer lastWeek;
}
