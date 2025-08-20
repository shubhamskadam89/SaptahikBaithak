package com.baithak.assignment.dto;

import com.baithak.assignment.model.Gender;
import lombok.*;

import java.util.List;
import java.util.Queue;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailDto {
    private Long personId;
    private String name;
    private Gender gender;
    private List<String> lastBaithakLocations;
}
