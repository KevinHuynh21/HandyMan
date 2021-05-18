package com.example.HandyMan.ui.login;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.HandyMan.Data.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivityViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    public LoginActivityViewModel(Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRepository.getCurrentUser();
    }
}
