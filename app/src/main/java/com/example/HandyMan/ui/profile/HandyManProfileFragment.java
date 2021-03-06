package com.example.HandyMan.ui.profile;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

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

public class HandyManProfileFragment extends Fragment {

    private HandyManProfileViewModel mViewModel;

    private HandyManProfileViewModel handyManProfileViewModel;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.handy_man_profile_fragment, container, false);
        Profile profile1 = new Profile();
        handyManProfileViewModel = new ViewModelProvider(this).get(HandyManProfileViewModel.class);
        TextView fullName = view.findViewById(R.id.fullName);
        TextView company = view.findViewById(R.id.company);
        TextView description = view.findViewById(R.id.description);
        TextView phoneNumber = view.findViewById(R.id.phoneNumber);
        TextView email = view.findViewById(R.id.email);
        Button button = view.findViewById(R.id.save);
        handyManProfileViewModel.getProfile().observe(getViewLifecycleOwner(), profile -> {
            if(profile != null) {
                profile1.setProfile(profile);
                fullName.setText(profile1.getFullName());
                company.setText(profile1.getCompany());
                description.setText(profile1.getDescription());
                phoneNumber.setText(String.valueOf(profile1.getPhoneNumber()));
                email.setText(profile1.getEmail());
            }
        });

        button.setOnClickListener(v -> {
            Profile profile = new Profile();
            profile.setFullName(fullName.getText().toString().trim());
            profile.setCompany(company.getText().toString().trim());
            profile.setDescription(description.getText().toString().trim());
            profile.setPhoneNumber(Integer.parseInt(phoneNumber.getText().toString()));
            profile.setEmail(email.getText().toString().trim());
            handyManProfileViewModel.saveProfile(profile);
            Toast.makeText(getContext(), "Your Profile is saved", Toast.LENGTH_SHORT).show();
            MainActivity.navController.navigate(R.id.nav_gallery);
        });
        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HandyManProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}