package com.example.courseondemand;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.courseondemand.home_fragment_list.ListScheduleAdapter;
import com.example.courseondemand.home_fragment_list.ListScheduleModel;
import com.example.courseondemand.home_fragment_list.OrderResponse;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firestore.v1beta1.StructuredQuery;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends Fragment {
    private List<OrderResponse> mOrder = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private FirebaseFirestore db;
    private FirebaseAuth firebaseAuth;
    public ListenerRegistration mRegistration;
    private String uid;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_home, null);
        final Switch switchActive = v.findViewById(R.id.switchActive1);

        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getUid();
        db = FirebaseFirestore.getInstance();

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
                    getSchedule();
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
        mAdapter = new ListScheduleAdapter(mOrder);
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }


    private void getSchedule(){
        mRegistration = db.collection("orders")
                .whereEqualTo("tentor.UID", uid)
                .whereEqualTo("status", 0)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w(TAG, "Listen failed.", e);
                            return;
                        }
                        mOrder.clear();
                       for (QueryDocumentSnapshot doc : queryDocumentSnapshots){
                            OrderResponse order = doc.toObject(OrderResponse.class);
                            order.setId(doc.getId());
                            mOrder.add(order);
                       }
                       mAdapter.notifyDataSetChanged();
                    }
                });
    }

}
