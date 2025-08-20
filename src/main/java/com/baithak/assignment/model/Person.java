package com.baithak.assignment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @ElementCollection
    @CollectionTable(name = "person_locations", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "location", nullable = false)
    private List<String> lastBaithakLocations; // changed from Queue<String> to List<String>
}
