package com.example.courseondemand;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.courseondemand.home_fragment_list.ListScheduleAdapter;
import com.example.courseondemand.home_fragment_list.ListScheduleModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<ListScheduleModel> mLists = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);
        LinearLayout listEmpty = v.findViewById(R.id.llnoschedule);
        listEmpty.setVisibility(v.INVISIBLE);
        initRecyclerView(v);
        initDummy();
        return v;
    }

    private void initRecyclerView(View v) {
        mRecyclerView = v.findViewById(R.id.rvSchedule);
        mAdapter = new ListScheduleAdapter(mLists);
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void initDummy() {
        mLists.add(new ListScheduleModel("1", "Angela", "Monday", "Kalkulus", "08:30", "2 hours"));
        mLists.add(new ListScheduleModel("2", "Angela", "Monday", "Kalkulus", "08:30", "2 hours"));
        mLists.add(new ListScheduleModel("3", "Angela", "Monday", "Kalkulus", "08:30", "2 hours"));
        mLists.add(new ListScheduleModel("4", "Angela", "Monday", "Kalkulus", "08:30", "2 hours"));
        mAdapter.notifyDataSetChanged();
    }


}
