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
import android.widget.LinearLayout;

import com.example.courseondemand.home_fragment_list.ListScheduleAdapter;
import com.example.courseondemand.home_fragment_list.OrderResponse;
import com.example.courseondemand.home_fragment_list.OrdersAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class OrdersFragment extends Fragment {

    private List<OrderResponse> mOrder = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private FirebaseFirestore db;
    private FirebaseAuth firebaseAuth;
    public ListenerRegistration mRegistOrder;
    private String uid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_orders, null);

        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getUid();
        db = FirebaseFirestore.getInstance();

        initRecyclerView(v);
        getSchedule();


        return v;
    }

    private void initRecyclerView(View v) {
        mRecyclerView = v.findViewById(R.id.rvScheduleOrders);
        mAdapter = new OrdersAdapter(mOrder);
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void getSchedule(){
        mRegistOrder = db.collection("orders")
                .whereEqualTo("tentor.UID", uid)
                .whereEqualTo("status", 1)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w(TAG, "Listen failed.", e);
                            return;
                        }
                        for (QueryDocumentSnapshot doc : queryDocumentSnapshots){
                            OrderResponse order1 = doc.toObject(OrderResponse.class);
                            order1.setId(doc.getId());
                            mOrder.add(order1);
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                });
    }
}
