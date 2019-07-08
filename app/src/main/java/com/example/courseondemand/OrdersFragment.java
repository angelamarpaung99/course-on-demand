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
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.courseondemand.home_fragment_list.ListScheduleAdapter;
import com.example.courseondemand.home_fragment_list.ListScheduleModel;

import java.util.ArrayList;
import java.util.List;

public class OrdersFragment extends Fragment {

    private List<ListScheduleModel> mLists = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_orders, null);
        RecyclerView orderList = v.findViewById(R.id.rvScheduleOrders);
        initRecyclerView(v);
        initDummy();
        return v;
    }

    private void initRecyclerView(View v) {
        mRecyclerView = v.findViewById(R.id.rvScheduleOrders);
        mAdapter = new ListScheduleAdapter(mLists);
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void initDummy() {
        mLists.add(new ListScheduleModel("1", "Angela", "Monday", "Kalkulus 1","11:30", "12:00","1 hour", "Informatics", "Telkom University", "A week", "1 Meeting", 80000, 1));
        mLists.add(new ListScheduleModel("2", "Melissa", "Monday", "Kalkulus 1","11:30", "12:00","1 hour", "Informatics", "Telkom University", "A week", "1 Meeting", 80000, 1));
        mLists.add(new ListScheduleModel("3", "Claudia", "Monday", "Kalkulus 1","11:30", "12:00","1 hour", "Informatics", "Telkom University", "A week", "1 Meeting", 80000, 1));
        mLists.add(new ListScheduleModel("4", "Yolanda", "Monday", "Kalkulus 1","11:30", "12:00","1 hour", "Informatics", "Telkom University", "A week", "1 Meeting", 80000, 1));
        mAdapter.notifyDataSetChanged();
    }

}
