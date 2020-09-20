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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CourseFragment extends Fragment {

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

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_course, container, false);
        rootView.findViewById(R.id.course_layout).setPadding(Util.dpToPx(20), Util.dpToPx(20), Util.dpToPx(20), getActivity().findViewById(R.id.navigationView).getHeight());

        Data[] tut_data = new Data[]{new Data("타이틀1", "설명 1", R.drawable.ic_launcher_foreground),
                new Data("타이틀2", "설명 2", R.drawable.ic_launcher_foreground),
                new Data("타이틀3", "설명 3", R.drawable.ic_launcher_foreground),
                new Data("타이틀4", "설명 4", R.drawable.ic_launcher_foreground),
                new Data("타이틀5", "설명 5", R.drawable.ic_launcher_foreground),
                new Data("타이틀6", "설명 6", R.drawable.ic_launcher_foreground),
                new Data("타이틀7", "설명 7", R.drawable.ic_launcher_foreground),};
        LinearLayout tut_result = rootView.findViewById(R.id.course_tut_result);

        for (int i = 0; i < tut_data.length; i++) {
            View v = inflater.inflate(R.layout.view_my_course, tut_result, false);
            ((ImageView) v.findViewById(R.id.course_thumbnail)).setBackgroundResource(tut_data[i].thumbnailID);
            ((TextView) v.findViewById(R.id.course_title)).setText(tut_data[i].title);
            ((TextView) v.findViewById(R.id.course_desc)).setText(tut_data[i].desc);
            tut_result.addView(v);
        }

        Data[] study_data = new Data[]{new Data("타이틀11", "설명 11", R.drawable.ic_launcher_foreground),
                new Data("타이틀22", "설명 22", R.drawable.ic_launcher_foreground),
                new Data("타이틀33", "설명 33", R.drawable.ic_launcher_foreground),
                new Data("타이틀44", "설명 44", R.drawable.ic_launcher_foreground),
                new Data("타이틀55", "설명 55", R.drawable.ic_launcher_foreground),
                new Data("타이틀66", "설명 66", R.drawable.ic_launcher_foreground),
                new Data("타이틀77", "설명 77", R.drawable.ic_launcher_foreground),};
        LinearLayout study_result = rootView.findViewById(R.id.course_study_result);

        for (int i = 0; i < study_data.length; i++) {
            View v = inflater.inflate(R.layout.view_my_course, study_result, false);
            ((ImageView) v.findViewById(R.id.course_thumbnail)).setBackgroundResource(study_data[i].thumbnailID);
            ((TextView) v.findViewById(R.id.course_title)).setText(study_data[i].title);
            ((TextView) v.findViewById(R.id.course_desc)).setText(study_data[i].desc);
            study_result.addView(v);
        }

        return rootView;
    }
}
