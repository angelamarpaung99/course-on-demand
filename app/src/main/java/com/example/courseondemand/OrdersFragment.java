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
import com.example.courseondemand.home_fragment_list.OrderAccepted;
import com.example.courseondemand.home_fragment_list.OrderResponse;
import com.example.courseondemand.home_fragment_list.OrdersAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class OrdersFragment extends Fragment {

    private ArrayList<OrderAccepted> mLists = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;
    private String uid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_orders, null);

        RecyclerView orderList = v.findViewById(R.id.rvScheduleOrders);

        Bundle bundle = getArguments();
        if (bundle != null){
            mLists = getArguments().getParcelableArrayList("orderlist");
            LinearLayout listNotEmpty = v.findViewById(R.id.llOrders);
            listNotEmpty.setVisibility(View.VISIBLE);
            initRecyclerView(v);
        } else {

        }


        return v;
    }

    private void initRecyclerView(View v) {
        mRecyclerView = v.findViewById(R.id.rvScheduleOrders);
        mAdapter = new OrdersAdapter(mLists);
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

}
