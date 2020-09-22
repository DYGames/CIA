package com.dygames.cia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TutAdapter extends RecyclerView.Adapter<TutAdapter.ViewHolder> {

    private DetailStudyFragment fragmentDetail = new DetailStudyFragment();

    public static class Data {
        public String title;
        public String desc;
        public int thumbnailID;

        public Data(String title, String desc, int thumbnailID) {
            this.title = title;
            this.desc = desc;
            this.thumbnailID = thumbnailID;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView title;
        public TextView desc;
        public ViewHolder(View v) {
            super(v);
            this.thumbnail = v.findViewById(R.id.view_tut_thumbnail);
            this.title = v.findViewById(R.id.view_tut_title);
            this.desc = v.findViewById(R.id.view_tut_desc);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((FragmentActivity)v.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentDetail).commitAllowingStateLoss();
                    ((BottomNavigationView)((FragmentActivity)v.getContext()).findViewById(R.id.navigationView)).getMenu().setGroupCheckable(0, false, true);
                }
            });
        }
    }

    Data[] data;

    public TutAdapter(Data[] d)
    {
        this.data = d;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_course_item, parent, false);
        ViewHolder h = new ViewHolder(holderView);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.thumbnail.setBackgroundResource(this.data[position].thumbnailID);
        holder.title.setText(this.data[position].title);
        holder.desc.setText(this.data[position].desc);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

}
