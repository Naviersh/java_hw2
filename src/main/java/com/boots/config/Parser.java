package com.boots.config;


import com.boots.entity.School;
import com.boots.repository.AddressesRepository;
import com.boots.repository.DistrictRepository;
import com.boots.repository.SchoolRepository;
import com.boots.entity.District;
import com.boots.entity.Address;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Parser {
    public Parser(DistrictRepository districtRepository, AddressesRepository addressesRepository, SchoolRepository schoolRepository) {
        if (districtRepository.count() > 0) {
            return;
        }
        ArrayList<District> districts = new ArrayList<>();
        districts.add(new District());
        districts.add(new District());
        districts.add(new District());
        districts.add(new District());
        districtRepository.saveAll(districts);

        int i = 0;
        List<Address> addresses = new ArrayList<>(30);
        for (String addressName : new String[]{
                "93403 Fahey Harbors Port Jermain",
                "57962 Pagac Meadow Shannonton",
                "464 Gerardo Radial Raymouth",
                "60001 Clare Parkway Apt. 574 Sallyville",
                "709 Davis Valleys Apt. 510 East Samirton",
                "703 Price Grove Apt. 770 Jacobschester",
                "1751 DuBuque Harbor Apt. 497 Lake Linnea",
                "1097 Kling Points Suite 513 West Curtmouth",
                "260 Satterfield Lodge North Marcellusmouth",
                "8908 Glennie Pine East Joaquin",
                "510 Hyatt Dam Turcotteborough",
        }) {
            Address address = new Address(addressName);
            addresses.add(address);
            address.setDistrict(districts.get(i % 3));
            i++;
        }
        addressesRepository.saveAll(addresses);

        List<School> schools = new ArrayList<>(30);
        for (i = 0; i < 10; i++) {
           schools.add(new School("School №" + i+1, addresses.get(i)));
        }
        schoolRepository.saveAll(schools);
    }
}
