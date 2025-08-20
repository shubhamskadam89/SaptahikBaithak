package com.baithak.assignment.dto.Mappers;

import com.baithak.assignment.dto.UserDetailDto;
import com.baithak.assignment.model.Person;

public class MemberMapper {

    public static UserDetailDto toDto(Person person) {
        if (person == null) {
            return null;
        }
        return UserDetailDto.builder()
                .personId(person.getPersonId())
                .name(person.getName())
                .gender(person.getGender())
                .lastBaithakLocations(person.getLastBaithakLocations())
                .build();
    }

    public static Person toEntity(UserDetailDto dto) {
        if (dto == null) {
            return null;
        }
        return Person.builder()
                .personId(dto.getPersonId())
                .name(dto.getName())
                .gender(dto.getGender())
                .lastBaithakLocations(dto.getLastBaithakLocations())
                .build();
    }
}
