package com.boots.entity;

import javax.persistence.*;

@Table(name = "addresses")
@Entity
public class Address {
    @Id
    @GeneratedValue
    public int id;

    @ManyToOne
    @JoinColumn(name = "districtId")
    public District district;
    public String address;

    public Address() {}

    public Address(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public int setID(int id){
        this.id = id;
        return id;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
