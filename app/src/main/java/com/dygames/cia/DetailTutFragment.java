package com.dygames.cia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailTutFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_study, container, false);
        //TODO : detail tut scroll => view detail tut item (make adapter)
        RecyclerView member_scroll = rootView.findViewById(R.id.detail_tut_scroll);
        member_scroll.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        member_scroll.setHasFixedSize(true);
        member_scroll.setAdapter(new DetailMemberAdapter(new DetailMemberAdapter.Data[]
                {new DetailMemberAdapter.Data("김도엽 1", R.drawable.ic_launcher_background),
                        new DetailMemberAdapter.Data("김도엽 2", R.drawable.ic_launcher_background),
                        new DetailMemberAdapter.Data("김도엽 3", R.drawable.ic_launcher_background),
                        new DetailMemberAdapter.Data("김도엽 4", R.drawable.ic_launcher_background),
                        new DetailMemberAdapter.Data("김도엽 5", R.drawable.ic_launcher_background),
                        new DetailMemberAdapter.Data("김도엽 6", R.drawable.ic_launcher_background),
                }));

        final ConstraintLayout tut_layout = (ConstraintLayout) rootView.findViewById(R.id.detail_tut_layout);
        tut_layout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tut_layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ((FrameLayout.LayoutParams) tut_layout.getLayoutParams()).setMargins(0, tut_layout.getRootView().findViewById(R.id.detail_tut_thumbnail).getHeight(), 0, 0);
                tut_layout.setPadding(Util.dpToPx(20), 0, Util.dpToPx(20), 400);
            }
        });
        return rootView;
    }
}
