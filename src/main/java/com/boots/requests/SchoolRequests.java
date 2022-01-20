package com.boots.requests;

import com.boots.entity.School;
import com.boots.repository.SchoolRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolRequests {
    public final SchoolRepository schoolRepository;

    public SchoolRequests(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getById(int id) {
        return schoolRepository.findById(id).orElse(null);
    }
}