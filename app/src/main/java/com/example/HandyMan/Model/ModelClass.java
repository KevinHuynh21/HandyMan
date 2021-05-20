package com.example.HandyMan.Model;


import com.example.HandyMan.Data.Profile;
import com.example.HandyMan.Data.ProfileRepository;

import java.util.Date;

public class ModelClass {
    private Profile profile;
    private static ModelClass instance;
    private String textMessage;
    private String textUser;
    private long timeOfMessage;


    public ModelClass()
    {

    }

    public ModelClass(String textMessage, String textUser)
    {
        this.textMessage = textMessage;
        this.textUser = textUser;
        timeOfMessage = new Date().getTime();
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

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTextUser() {
        return textUser;
    }

    public void setTextUser(String textUser) {
        this.textUser = textUser;
    }

    public long getTimeOfMessage() {
        return timeOfMessage;
    }

    public void setTimeOfMessage(long timeOfMessage) {
        this.timeOfMessage = timeOfMessage;
    }
}
