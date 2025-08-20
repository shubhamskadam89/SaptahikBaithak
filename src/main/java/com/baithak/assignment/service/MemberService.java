package com.baithak.assignment.service;

import com.baithak.assignment.dto.UserDetailDto;

import java.util.List;

public interface MemberService {

    List<UserDetailDto> findAll();
    List<UserDetailDto> findAllFemale();
    List<UserDetailDto> findAllMale();
}
