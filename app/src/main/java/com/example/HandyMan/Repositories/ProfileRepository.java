package com.example.HandyMan.Repositories;

import com.example.HandyMan.Data.Profile;
import com.example.HandyMan.Data.ProfileListLiveData;
import com.example.HandyMan.Data.ProfileLiveData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileRepository {
    private static ProfileRepository instance;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private DatabaseReference myRefList;
    private ProfileLiveData profileLiveData;
    private ProfileListLiveData profileListLiveData;


    private ProfileRepository(){

    }

    public void init(String userId)
    {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Profile").child(userId);
        myRefList = database.getReference("Profile");
        profileLiveData = new ProfileLiveData(myRef);
        profileListLiveData = new ProfileListLiveData(myRefList);
    }


    public static synchronized ProfileRepository getInstance() {
        if(instance == null)
            instance = new ProfileRepository();
        return instance;
    }

    public void saveProfile(Profile profile) {
        myRef.setValue(profile);
    }

    public ProfileLiveData getProfile() {
        return profileLiveData;
    }

    public ProfileListLiveData getAllProfiles()
    {
        return profileListLiveData;
    }


}
