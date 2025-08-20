package com.baithak.assignment.service.impl;

import com.baithak.assignment.dto.Mappers.MemberMapper;
import com.baithak.assignment.dto.UserDetailDto;
import com.baithak.assignment.model.Gender;
import com.baithak.assignment.model.Person;
import com.baithak.assignment.repository.PersonRepository;
import com.baithak.assignment.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final PersonRepository personRepository;

    @Override
    public List<UserDetailDto> findAll() {
        log.info("Fetching all members");
        List<Person> members = personRepository.findAll();
        log.debug("Fetched {} members from DB", members.size());

        return members.stream()
                .map(MemberMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailDto> findAllFemale() {
        log.info("Fetching all female members");
        List<Person> females = personRepository.findByGender(Gender.FEMALE);
        log.debug("Fetched {} female members from DB", females.size());

        return females.stream()
                .map(MemberMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailDto> findAllMale() {
        log.info("Fetching all male members");
        List<Person> males = personRepository.findByGender(Gender.MALE);
        log.debug("Fetched {} male members from DB", males.size());

        return males.stream()
                .map(MemberMapper::toDto)
                .collect(Collectors.toList());
    }
}
