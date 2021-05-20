package com.example.HandyMan.ui.gallery;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.HandyMan.Data.Profile;
import com.example.HandyMan.Repositories.ProfileRepository;

import java.util.List;


public class GalleryViewModel extends AndroidViewModel {
    private final ProfileRepository profileRepository;

    public GalleryViewModel(Application application) {
            super(application);
            profileRepository = ProfileRepository.getInstance();
        }


        public LiveData<List<Profile>> getAllProfiles() {
            return profileRepository.getAllProfiles();
        }


}