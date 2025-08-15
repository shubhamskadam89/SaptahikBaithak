package com.baithak.assignment.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor @Builder
@Entity
public class Members {

    private Long memberId;

    private String memberName;

    private Gender gender;

    private String phoneNumber;
}
