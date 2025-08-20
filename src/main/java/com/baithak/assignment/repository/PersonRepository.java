package com.baithak.assignment.repository;

import com.baithak.assignment.model.Gender;
import com.baithak.assignment.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // find a person by name
    Person findByName(String name);

    // all females
    List<Person> findByGender(Gender gender);

    // if you want explicit methods for clarity
    default List<Person> findAllFemales() {
        return findByGender(Gender.FEMALE);
    }

    default List<Person> findAllMales() {
        return findByGender(Gender.MALE);
    }
}
