package com.example.HandyMan;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.HandyMan.Data.Profile;
import com.example.HandyMan.Data.ProfileRepository;
import com.example.HandyMan.Data.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public MainActivityViewModel(Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
        profileRepository = ProfileRepository.getInstance();
    }
    public void init() {
        String userId = userRepository.getCurrentUser().getValue().getUid();
        profileRepository.init(userId);
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }



    public void logout()
    {
        userRepository.signOut();
    }
}
