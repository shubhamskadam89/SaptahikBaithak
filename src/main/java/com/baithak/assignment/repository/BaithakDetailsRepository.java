package com.baithak.assignment.repository;

import com.baithak.assignment.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaithakDetailsRepository extends JpaRepository<Assignment,Long> {


}
