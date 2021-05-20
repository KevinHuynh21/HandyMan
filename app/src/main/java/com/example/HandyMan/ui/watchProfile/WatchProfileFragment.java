package com.example.HandyMan.ui.watchProfile;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.HandyMan.Data.Profile;
import com.example.HandyMan.MainActivity;
import com.example.HandyMan.R;
import com.example.HandyMan.ui.chat.ChatActivity;

public class WatchProfileFragment extends Fragment {

    private WatchProfileViewModel watchProfileViewModel;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.watch_profile_fragment, container, false);
        watchProfileViewModel = new ViewModelProvider(this).get(WatchProfileViewModel.class);
        TextView fullName = view.findViewById(R.id.fullName);
        TextView company = view.findViewById(R.id.company);
        TextView description = view.findViewById(R.id.description);
        TextView phoneNumber = view.findViewById(R.id.phoneNumber);
        TextView email = view.findViewById(R.id.email);
        Button chat = view.findViewById(R.id.button2);
        Profile profile = watchProfileViewModel.getProfileFromModel();
        if(profile != null)
        {
            fullName.setText(profile.getFullName());
            company.setText(profile.getCompany());
            description.setText(profile.getDescription());
            phoneNumber.setText(String.valueOf(profile.getPhoneNumber()));
            email.setText(profile.getEmail());
        }
        chat.setOnClickListener(v -> {
            goToChatActivity();
        });
        return view;
    }

    private void goToChatActivity() {
        startActivity(new Intent(getContext(), ChatActivity.class));
    }

}