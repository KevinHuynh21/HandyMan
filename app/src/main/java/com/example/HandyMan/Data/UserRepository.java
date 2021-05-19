package com.example.HandyMan.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

public class UserRepository {
        private final UserLiveData currentUser;
        private static UserRepository instance;
        private final Application app;

        private UserRepository(Application app) {
            this.app = app;
            currentUser = new UserLiveData();
        }

        public static synchronized UserRepository getInstance(Application app) {
            if(instance == null)
                instance = new UserRepository(app);
            return instance;
        }

    public void signOut() {
        AuthUI.getInstance()
                .signOut(app.getApplicationContext());
    }

        public LiveData<FirebaseUser> getCurrentUser() {
            return currentUser;
        }


}

