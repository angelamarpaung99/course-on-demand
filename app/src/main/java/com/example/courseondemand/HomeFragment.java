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
import android.widget.RelativeLayout;
import android.widget.Switch;

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
        final View v = inflater.inflate(R.layout.fragment_home, null);
        final Switch switchActive = v.findViewById(R.id.switchActive1);
        switchActive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    switchActive.setText("Active  ");
                    LinearLayout listEmpty = v.findViewById(R.id.llnoschedule);
                    RecyclerView listNotEmpty = v.findViewById(R.id.rvSchedule);
                    listEmpty.setVisibility(v.INVISIBLE);
                    listNotEmpty.setVisibility(v.VISIBLE);
                    initRecyclerView(v);
                    initDummy();
                } else {
                    switchActive.setText("Not Active  ");
                    RecyclerView listNotEmpty = v.findViewById(R.id.rvSchedule);
                    LinearLayout listEmpty = v.findViewById(R.id.llnoschedule);
                    listNotEmpty.setVisibility(v.INVISIBLE);
                    listEmpty.setVisibility(v.VISIBLE);

                }
            }
        });
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
        mLists.add(new ListScheduleModel("1", "Angela", "Monday", "Kalkulus", "08:30", "2 hours","Informatics", "one week", "one meeting", "A week", "1 Meeting", 80000, 1 ));
        mLists.add(new ListScheduleModel("2", "Melissa", "Monday", "Kalkulus", "08:30", "2 hours","Informatics", "one week", "one meeting", "A week", "1 Meeting", 80000, 1 ));
        mLists.add(new ListScheduleModel("3", "Claudia", "Monday", "Kalkulus", "08:30", "2 hours","Informatics", "one week", "one meeting", "A week", "1 Meeting", 80000, 1 ));
        mLists.add(new ListScheduleModel("4", "Yolanda", "Monday", "Kalkulus", "08:30", "2 hours","Informatics", "one week", "one meeting", "A week", "1 Meeting", 80000, 1 ));
        mAdapter.notifyDataSetChanged();
    }


}
