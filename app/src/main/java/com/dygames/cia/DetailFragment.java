package com.dygames.cia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        RecyclerView member_scroll = rootView.findViewById(R.id.detail_member_scroll);
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

        return rootView;
    }
}
