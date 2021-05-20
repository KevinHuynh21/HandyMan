package com.example.HandyMan.Data;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProfileListLiveData extends LiveData<List<Profile>> {

    DatabaseReference databaseReference;
    private ArrayList<Profile> list = new ArrayList<>();
    private final ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange( DataSnapshot snapshot) {
            list.clear();
            for (DataSnapshot dataSnap: snapshot.getChildren()) {
                Profile profile = dataSnap.getValue(Profile.class);
                list.add(profile);
            }
            setValue(list);

        }

        @Override
        public void onCancelled(DatabaseError error) {
            Log.w("Failed to read value.", error.toException());
        }
    };


    public ProfileListLiveData(DatabaseReference ref) {
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
