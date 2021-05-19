package com.example.HandyMan.Data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ProfileLiveData extends LiveData<Profile> {
    DatabaseReference databaseReference;
    private final ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange( DataSnapshot snapshot) {
            Profile profile = snapshot.getValue(Profile.class);
            setValue(profile);
        }

        @Override
        public void onCancelled(DatabaseError error) {
            Log.w("Failed to read value.", error.toException());
        }
    };


    public ProfileLiveData(DatabaseReference ref) {
        databaseReference = ref;
    }

    @Override
    protected void onActive() {
        super.onActive();
        databaseReference.addValueEventListener(listener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        databaseReference.removeEventListener(listener);
    }

}
