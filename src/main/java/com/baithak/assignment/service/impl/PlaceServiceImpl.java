package com.baithak.assignment.service.impl;

import com.baithak.assignment.dto.Mappers.PlaceMappers;
import com.baithak.assignment.dto.PlaceDetailDto;
import com.baithak.assignment.model.Gender;
import com.baithak.assignment.model.Place;
import com.baithak.assignment.repository.PlacesRepository;
import com.baithak.assignment.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlacesRepository placesRepository;

    @Override
    public List<PlaceDetailDto> findAll() {
        log.info("Fetching all places");
        List<Place> places = placesRepository.findAll();
        log.debug("Fetched {} places", places.size());
        return places.stream()
                .map(PlaceMappers::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlaceDetailDto> findAllMalePlaces() {
        log.info("Fetching all male places");
        List<Place> malePlaces = placesRepository.findByType(Gender.MALE);
        log.debug("Fetched {} male places", malePlaces.size());
        return malePlaces.stream()
                .map(PlaceMappers::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlaceDetailDto> findAllFemalePlaces() {
        log.info("Fetching all female places");
        List<Place> femalePlaces = placesRepository.findByType(Gender.FEMALE);
        log.debug("Fetched {} female places", femalePlaces.size());
        return femalePlaces.stream()
                .map(PlaceMappers::toDto)
                .collect(Collectors.toList());
    }
}
