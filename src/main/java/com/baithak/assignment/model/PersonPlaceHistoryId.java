package com.baithak.assignment.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonPlaceHistoryId implements Serializable {
    private Long person;
    private Long place;
}
