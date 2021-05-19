package com.example.HandyMan.Data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileRepository {
    private static ProfileRepository instance;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private ProfileLiveData  profileLiveData;


    private ProfileRepository(){

    }

    public void init(String userId)
    {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Profile").child(userId);
        profileLiveData = new ProfileLiveData(myRef);
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


}
