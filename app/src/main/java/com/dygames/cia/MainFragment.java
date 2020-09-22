package com.dygames.cia;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainFragment extends Fragment {

    private com.dygames.cia.CategoryFragment categoryFragment = new com.dygames.cia.CategoryFragment();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        rootView.findViewById(R.id.main_layout).setPadding(Util.dpToPx(20), Util.dpToPx(100), Util.dpToPx(20), getActivity().findViewById(R.id.navigationView).getHeight());
        final CustomActionBar actionBar = rootView.findViewById(R.id.main_actionbar);
        final ScrollView main_scrollView = (ScrollView) rootView.findViewById(R.id.main_layout).getParent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            main_scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    actionBar.setColor(scrollY);
                }
            });
        } else {
            main_scrollView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    actionBar.setColor(main_scrollView.getScrollY());
                    return false;
                }
            });
        }
        RecyclerView recommend_tut = rootView.findViewById(R.id.recommend_tut_scroll);
        recommend_tut.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recommend_tut.setHasFixedSize(true);
        recommend_tut.setAdapter(new TutAdapter(new TutAdapter.Data[]
                {new TutAdapter.Data("타이틀 1", "설명 1", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 2", "설명 2", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 3", "설명 3", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 4", "설명 4", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 5", "설명 5", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 6", "설명 6", R.drawable.ic_launcher_background),
                }));

        RecyclerView recommend_study = rootView.findViewById(R.id.recommend_study_scroll);
        recommend_study.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recommend_study.setHasFixedSize(true);
        recommend_study.setAdapter(new TutAdapter(new TutAdapter.Data[]
                {new TutAdapter.Data("타이틀 11", "설명 11", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 22", "설명 22", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 33", "설명 33", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 44", "설명 44", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 55", "설명 55", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 66", "설명 66", R.drawable.ic_launcher_background),
                }));

        RecyclerView trend_tut = rootView.findViewById(R.id.trend_tut_scroll);
        trend_tut.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        trend_tut.setHasFixedSize(true);
        trend_tut.setAdapter(new TutAdapter(new TutAdapter.Data[]
                {new TutAdapter.Data("타이틀 111", "설명 111", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 222", "설명 222", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 333", "설명 333", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 444", "설명 444", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 555", "설명 555", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 666", "설명 666", R.drawable.ic_launcher_background),
                }));

        RecyclerView trend_study = rootView.findViewById(R.id.trend_study_scroll);
        trend_study.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        trend_study.setHasFixedSize(true);
        trend_study.setAdapter(new TutAdapter(new TutAdapter.Data[]
                {new TutAdapter.Data("타이틀 1111", "설명 1111", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 2222", "설명 2222", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 3333", "설명 3333", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 4444", "설명 4444", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 5555", "설명 5555", R.drawable.ic_launcher_background),
                        new TutAdapter.Data("타이틀 6666", "설명 6666", R.drawable.ic_launcher_background),
                }));

        ChipGroup chipGroup = rootView.findViewById(R.id.category_chipgroup);
        for (int i = 0, c = chipGroup.getChildCount(); i < c; i++) {
            (chipGroup.getChildAt(i)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, categoryFragment).commitAllowingStateLoss();
                }
            });
        }

        return rootView;
    }
}
