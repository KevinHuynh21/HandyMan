package com.example.HandyMan.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.HandyMan.Data.Profile;
import com.example.HandyMan.Data.ProfileDataForRecyclerView;
import com.example.HandyMan.MainActivity;
import com.example.HandyMan.Model.ModelClass;
import com.example.HandyMan.R;
import java.util.ArrayList;


public class GalleryFragment extends Fragment implements GalleryAdapter.OnItemClickListener {

    private GalleryViewModel galleryViewModel;
    private RecyclerView recyclerView;
    private GalleryAdapter galleryAdapter;
    private ArrayList<ProfileDataForRecyclerView> list = new ArrayList<>();
    private final ModelClass modelClass = ModelClass.getInstance();

    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        galleryAdapter = new GalleryAdapter(list, this);
        galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        galleryViewModel.getAllProfiles().observe(getViewLifecycleOwner(), profiles -> {
            if(profiles != null)
            {
                list.clear();
                for (Profile profile: profiles) {
                    list.add(new ProfileDataForRecyclerView(profile.getFullName(), R.drawable.profile_picture, profile.getCompany()));
                }
                galleryAdapter.notifyDataSetChanged();
            }
        });

        recyclerView.setAdapter(galleryAdapter);



        return view;
    }

    @Override
    public void onItemClick(int IndexOfClickedItem) {
        galleryViewModel.getAllProfiles().observe(getViewLifecycleOwner(), profiles -> {
            if(profiles != null)
            {
                for (Profile profile: profiles) {
                    if((profile.getFullName().equals(list.get(IndexOfClickedItem).getName()) && (profile.getCompany().equals(list.get(IndexOfClickedItem).getCompany()))))
                    {
                        modelClass.setProfile(profile);
                    }
                }
            }
            MainActivity.navController.navigate(R.id.nav_watchProfile);
        });
    }
}