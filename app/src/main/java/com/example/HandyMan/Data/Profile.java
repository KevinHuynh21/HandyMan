package com.example.HandyMan.Data;

public class Profile {
    private String fullName;
    private String company;
    private String description;
    private int phoneNumber;
    private String email;
    public Profile()
    {
    }

    public void setProfile(Profile profile)
    {
        this.fullName = profile.getFullName();
        this.company = profile.getCompany();
        this.description = profile.getDescription();
        this.phoneNumber = profile.getPhoneNumber();
        this.email = profile.getEmail();
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
