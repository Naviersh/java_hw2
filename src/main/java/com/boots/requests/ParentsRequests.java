package com.boots.requests;


import com.boots.entity.Address;
import com.boots.entity.Parents;
import com.boots.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParentsRequests {
    private final ParentRepository parentRepository;
    private final AddressRequests addressRequests;

    public ParentsRequests(ParentRepository parentsRepository, AddressRequests addressRequests) {
        this.parentRepository = parentsRepository;
        this.addressRequests = addressRequests;
    }

    public Parents AddOrUpdateParents(Parents parents) {
        parentRepository.save(parents);
        return parents;
    }

    public Parents addOrUpdateParents(Parents parents, int addressId) {
        if (addressId != -1) {
            Address address = addressRequests.getById(addressId);
            if (address != null) {
                parents.setAddress(address);
            }
        }
        parentRepository.save(parents);
        return parents;
    }

    public List<Parents> GetAllParents() {
        return parentRepository.findAll();
    }

    public Parents GetById(int id) {
        return parentRepository.getById(id);
    }
}