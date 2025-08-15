package com.baithak.assignment.entity;


import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class BaithakDetails {

    private Long id;

    private Members member;

    private Places place;

    private Days day;

    private Date date;



}
