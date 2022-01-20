package com.boots.entity;

import javax.persistence.*;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue
    public int id;

    public School() {
    }

    public School(String number, Address address) {
        this.number = number;
        this.address = address;
    }

    public String number;

    @ManyToOne
    @JoinColumn(name = "addressId")
    public Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
