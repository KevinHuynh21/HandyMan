package com.example.HandyMan.Model;


import com.example.HandyMan.Data.Profile;
import com.example.HandyMan.Data.ProfileRepository;

public class ModelClass {
    private Profile profile;
    private static ModelClass instance;


    public ModelClass()
    {

    }

    public static synchronized ModelClass getInstance() {
        if(instance == null)
            instance = new ModelClass();
        return instance;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
