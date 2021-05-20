package com.example.HandyMan.ui.watchProfile;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.HandyMan.Data.Profile;
import com.example.HandyMan.Data.ProfileRepository;
import com.example.HandyMan.Model.ModelClass;


public class WatchProfileViewModel extends AndroidViewModel {
    private ProfileRepository profileRepository;
    private final ModelClass modelClass;
    public WatchProfileViewModel(Application application) {
        super(application);
        profileRepository = ProfileRepository.getInstance();
        modelClass = ModelClass.getInstance();
    }

    public Profile getProfileFromModel()
    {
        return modelClass.getProfile();
    }
}