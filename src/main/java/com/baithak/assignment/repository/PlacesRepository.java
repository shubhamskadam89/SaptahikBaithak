package com.baithak.assignment.repository;

import com.baithak.assignment.model.Gender;
import com.baithak.assignment.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacesRepository extends JpaRepository<Place, Long> {

    Place findByName(String name);

    // all places of males
    List<Place> findByType(Gender type);

    // optional convenience
    default List<Place> findAllMalePlaces() {
        return findByType(Gender.MALE);
    }

    default List<Place> findAllFemalePlaces() {
        return findByType(Gender.FEMALE);
    }
}
