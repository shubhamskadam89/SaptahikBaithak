package com.baithak.assignment.service;

import com.baithak.assignment.dto.PlaceDetailDto;

import java.util.List;

public interface PlaceService {
    List<PlaceDetailDto> findAll();
    List<PlaceDetailDto> findAllMalePlaces();
    List<PlaceDetailDto> findAllFemalePlaces();
}
