package com.baithak.assignment.dto.Mappers;

import com.baithak.assignment.dto.PlaceDetailDto;
import com.baithak.assignment.model.Place;

public class PlaceMappers {

    public static PlaceDetailDto toDto(Place place) {
        if (place == null) {
            return null;
        }
        return PlaceDetailDto.builder()
                .placeId(place.getPlaceId())
                .name(place.getName())
                .type(place.getType())
                .meetingDay(place.getMeetingDay())
                .timeSlot(place.getTimeSlot())
                .build();
    }

    public static Place toEntity(PlaceDetailDto dto) {
        if (dto == null) {
            return null;
        }
        return Place.builder()
                .placeId(dto.getPlaceId())
                .name(dto.getName())
                .type(dto.getType())
                .meetingDay(dto.getMeetingDay())
                .timeSlot(dto.getTimeSlot())
                .build();
    }
}
