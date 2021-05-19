package com.example.HandyMan.ui.profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.HandyMan.Data.Profile;
import com.example.HandyMan.Data.ProfileRepository;

public class HandyManProfileViewModel extends AndroidViewModel {
    private final ProfileRepository profileRepository;
    public HandyManProfileViewModel(Application application) {
        super(application);
        profileRepository = ProfileRepository.getInstance();
    }
    public LiveData<Profile> getProfile() {
        return profileRepository.getProfile();
    }

    public void saveProfile(Profile profile) {
        profileRepository.saveProfile(profile);
    }
}