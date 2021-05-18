package com.example.HandyMan;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.HandyMan.Data.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    public MainActivityViewModel(Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
    }
    public void init() {
        String userId = userRepository.getCurrentUser().getValue().getUid();
      // messageRepository.init(userId);
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }
/*
    public void saveMessage(String message) {
        messageRepository.saveMessage(message);
    }

    public LiveData<Message> getMessage() {
        return messageRepository.getMessage();
    }*/

    public void logout()
    {
        userRepository.signOut();
    }
}
