package com.boots.requests;

import com.boots.entity.Address;
import org.springframework.stereotype.Service;
import com.boots.repository.AddressesRepository;
import java.util.List;

@Service
public class AddressRequests {
    private final AddressesRepository addressesRepository;

    public List<Address> getAllAddresses() {
        return addressesRepository.findAll();
    }

    public AddressRequests(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    public Address getById(int id) {
        return addressesRepository.findById(id).orElse(null);
    }
}
