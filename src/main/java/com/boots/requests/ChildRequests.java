package com.boots.requests;

import com.boots.entity.Child;
import com.boots.entity.Parents;
import com.boots.entity.School;
import com.boots.repository.ChildRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildRequests {
    private final ChildRepository childRepository;
    private final ParentsRequests parentsRequests;
    private final SchoolRequests schoolRequests;

    public ChildRequests(ChildRepository childRepository, ParentsRequests parentsRequests, SchoolRequests schoolRequests) {
        this.childRepository = childRepository;
        this.parentsRequests = parentsRequests;
        this.schoolRequests = schoolRequests;
    }

    public Child addChild(Child child, Integer parentsId) {
        Parents parents = parentsRequests.GetById(parentsId);
        if (parents == null) {
            return null;
        }
        child.setParents(parents);
        childRepository.save(child);
        return child;
    }

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    public Child getById(int id) {
        return childRepository.findById(id).orElse(null);
    }

    public List<School> getSchools(Child child) {
        Parents parents = child.getParents();
        if (parents.getAddress() != null) {
            List<School> schools = schoolRequests.getAllSchools();
            return schools.stream().filter(x -> parents.getAddress().getDistrict().getAddresses().stream().anyMatch(y -> y.getId() == x.getAddress().getId())).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public boolean setSchools(int childId, int schoolId) {
        Child child = this.getById(childId);
        if (child == null) {
            return false;
        }
        if (schoolId== -1) {
            child.setSchool(null);
        } else {
            School school = schoolRequests.getById(schoolId);
            if (school == null) {
                return false;
            }
            child.setSchool(school);
        }
        childRepository.save(child);
        return true;
    }
}
