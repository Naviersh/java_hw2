package com.boots.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "parents")
@Entity
public class Parents {
    @Id
    @GeneratedValue
    public int id;
    public String fatherFullname;
    public String motherFullname;

    @OneToMany(mappedBy = "parents", cascade = CascadeType.ALL)
    public List<Child> children = new ArrayList<Child>();

    @ManyToOne
    @JoinColumn(name = "addressId")
    public Address address;

    public Parents(){}

    public Parents(String fatherFullname, String motherFullname){
        setFatherFullName(fatherFullname);
        setMotherFullName(motherFullname);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFatherFullname() {
        return fatherFullname;
    }

    public void setFatherFullName(String fatherFullName) {
        if (!Objects.equals(fatherFullName, "")) {
            this.fatherFullname = fatherFullName;
        }
    }

    public String getMotherFullName() {
        return motherFullname;
    }

    public void setMotherFullName(String motherFullName) {
        if (!Objects.equals(motherFullName, "")) {
            this.motherFullname = motherFullName;
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
