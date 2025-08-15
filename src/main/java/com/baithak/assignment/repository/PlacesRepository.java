package com.baithak.assignment.repository;

import com.baithak.assignment.entity.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends JpaRepository<Places,Long> {
}
