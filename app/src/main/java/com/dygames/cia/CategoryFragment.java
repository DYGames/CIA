package com.dygames.cia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CategoryFragment extends Fragment {
    public class Data {
        public String title;
        public String desc;
        public int thumbnailID;

        public Data(String title, String desc, int thumbnailID) {
            this.title = title;
            this.desc = desc;
            this.thumbnailID = thumbnailID;
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        CategoryFragment.Data[] tut_data = new CategoryFragment.Data[]{new CategoryFragment.Data("타이틀1", "설명 1", R.drawable.ic_launcher_foreground),
                new CategoryFragment.Data("타이틀2", "설명 2", R.drawable.ic_launcher_foreground),
                new CategoryFragment.Data("타이틀3", "설명 3", R.drawable.ic_launcher_foreground),
                new CategoryFragment.Data("타이틀4", "설명 4", R.drawable.ic_launcher_foreground),
                new CategoryFragment.Data("타이틀5", "설명 5", R.drawable.ic_launcher_foreground),
                new CategoryFragment.Data("타이틀6", "설명 6", R.drawable.ic_launcher_foreground),
                new CategoryFragment.Data("타이틀7", "설명 7", R.drawable.ic_launcher_foreground),};
        LinearLayout category_layout = rootView.findViewById(R.id.category_layout);

        for (int i = 0; i < tut_data.length; i++) {
            View v = inflater.inflate(R.layout.view_course_bar, category_layout, false);
            ((ImageView) v.findViewById(R.id.course_bar_thumbnail)).setBackgroundResource(tut_data[i].thumbnailID);
            ((TextView) v.findViewById(R.id.course_bar_title)).setText(tut_data[i].title);
            ((TextView) v.findViewById(R.id.course_bar_desc)).setText(tut_data[i].desc);
            category_layout.addView(v);
        }

        return rootView;
    }
}
