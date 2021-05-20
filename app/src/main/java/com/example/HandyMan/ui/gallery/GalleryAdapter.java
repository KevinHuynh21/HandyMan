package com.example.HandyMan.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.HandyMan.Data.ProfileDataForRecyclerView;
import com.example.HandyMan.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private ArrayList<ProfileDataForRecyclerView> profileDataForRecyclerViews;
    final private OnItemClickListener onItemClickListener;

    public GalleryAdapter(ArrayList<ProfileDataForRecyclerView> profileDataForRecyclerViews, OnItemClickListener onItemClickListener){
        this.profileDataForRecyclerViews = profileDataForRecyclerViews;
        this.onItemClickListener = onItemClickListener;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_in_recyclerview_gallery, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.imageView.setImageResource(profileDataForRecyclerViews.get(position).getPicture());
        String nameAndCompany = "Name: " + profileDataForRecyclerViews.get(position).getName() + "\n" + "Company: " + profileDataForRecyclerViews.get(position).getCompany();
        viewHolder.textView.setText(nameAndCompany);
    }

    public int getItemCount() {
        return profileDataForRecyclerViews.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        ViewHolder(View viewItem) {
            super(viewItem);
            imageView = viewItem.findViewById(R.id.profilePicture);
            textView = viewItem.findViewById(R.id.name);
            viewItem.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAbsoluteAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int IndexOfClickedItem);
    }

}

