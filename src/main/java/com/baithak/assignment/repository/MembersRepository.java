package com.baithak.assignment.repository;

import com.baithak.assignment.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MembersRepository extends JpaRepository<Members,Long> {
}
