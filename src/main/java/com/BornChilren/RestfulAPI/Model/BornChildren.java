package com.BornChilren.RestfulAPI.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BornChildren")
public class BornChildren {
    //assumption : registrationNumber can be used to uniquely identify a child
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationNumber;
    private String nameOfTheChild;
    private String placeOfBirth;
    private LocalDate dateOfBirth;
    private String gender;
    private int weight;
    private String mothersName;
    private int mothersAge;
    private String mothersOccupation;
    private String maritalStatus;
    //alternative was to use lombok
    /*no argument constructor*/
    public BornChildren(){

    }
    /*constructor with registration number */
    public BornChildren(Long registrationNumber, String nameOfTheChild, String placeOfBirth, 
                    LocalDate dateOfBirth, String gender, int weight, String mothersName,
                    int mothersAge, String occupation, String maritalStatus){
        this.registrationNumber = registrationNumber;
        this.nameOfTheChild = nameOfTheChild;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.weight = weight;
        this.mothersName = mothersName;
        this.mothersAge = mothersAge;
        this.mothersOccupation = occupation;
        this.maritalStatus = maritalStatus;


    }
    /* constructor without registration number */
    public BornChildren(String nameOfTheChild, String placeOfBirth, LocalDate dateOfBirth,
                    String gender, int weight, String mothersName, int mothersAge, 
                    String occupation, String maritalStatus){
        this.nameOfTheChild = nameOfTheChild;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.weight = weight;
        this.mothersName = mothersName;
        this.mothersAge = mothersAge;
        this.mothersOccupation = occupation;
        this.maritalStatus = maritalStatus;

    }
    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getNameOfTheChild() {
        return nameOfTheChild;
    }

    public void setNameOfTheChild(String nameOfTheChild) {
        this.nameOfTheChild = nameOfTheChild;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public int getMothersAge() {
        return mothersAge;
    }

    public void setMothersAge(int mothersAge) {
        this.mothersAge = mothersAge;
    }

    public String getMothersOccupation() {
        return mothersOccupation;
    }

    public void setMothersOccupation(String occupation) {
        this.mothersOccupation = occupation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

}
