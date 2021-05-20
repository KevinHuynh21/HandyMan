package com.example.HandyMan.Data;

public class ProfileDataForRecyclerView {
    private String name;
    private int picture;
    private String company;

    public ProfileDataForRecyclerView(String name, int picture, String company) {
        this.name = name;
        this.picture = picture;
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }
}

