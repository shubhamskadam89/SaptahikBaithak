package com.baithak.assignment.repository;

import com.baithak.assignment.entity.BaithakDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaithakDetailsRepository extends JpaRepository<BaithakDetails,Long> {
}
