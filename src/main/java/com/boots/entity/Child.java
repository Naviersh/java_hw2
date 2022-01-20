package com.boots.entity;

import javax.persistence.*;

@Table(name = "children")
@Entity
public class Child {
    @Id
    @GeneratedValue
    public int id;

    @ManyToOne
    @JoinColumn(name = "parentsId")
    public Parents parents;
    public String fullname;

    public Child() {}

    public Child(String fullname, Parents parents, int age) {
        this.fullname = fullname;
        this.parents = parents;
        this.age = age;
    }

    public int age;

    @ManyToOne
    @JoinColumn(name = "schoolId")
    public School school;

    public School getSchool(){
        return school;
    }

    public void setSchool(School school){
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullName) {
        this.fullname = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
