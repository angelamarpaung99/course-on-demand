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
import android.widget.Toast;

import com.example.courseondemand.home_fragment_list.Bank;
import com.example.courseondemand.home_fragment_list.Lesson;
import com.example.courseondemand.home_fragment_list.ListScheduleAdapter;
import com.example.courseondemand.home_fragment_list.ListScheduleModel;
import com.example.courseondemand.home_fragment_list.Order;
import com.example.courseondemand.home_fragment_list.Packet;
import com.example.courseondemand.home_fragment_list.Payment;
import com.example.courseondemand.home_fragment_list.Teach;
import com.example.courseondemand.home_fragment_list.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

//    private List<ListScheduleModel> mLists = new ArrayList<>();
    private List<Order> mOrder = new ArrayList<>();
    private List<User> mUser = new ArrayList<>();
    private List <Lesson> mLesson = new ArrayList<>();
    private List<Bank> mBank = new ArrayList<>();
    private List<Packet> mPacket = new ArrayList<>();
    private List<Payment> mPayment = new ArrayList<>();
    private List<Teach> mTeach = new ArrayList<>();

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
        mAdapter = new ListScheduleAdapter(mOrder);
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

//    private void getSchedule(){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        CollectionReference ordersCollectionRef = db.collection("orders");
//
//        Query notesQuery = ordersCollectionRef.whereEqualTo("UID", FirebaseAuth.getInstance().getCurrentUser().getUid());
//
//        notesQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()){
//                    for (QueryDocumentSnapshot document: task.getResult())
//                            ListScheduleModel
//                } else {
//                    Toast.makeText(getContext(),"Query Failed. Check Logs.",Toast.LENGTH_SHORT).show();
//                }
//            }
//        })
//    }

//    private void initDummy() {
//        mLists.add(new ListScheduleModel("1", "Angela", "Monday", "Kalkulus 1","11:30", "12:00","1 hour", "Informatics", "Telkom University", "A week", "1 Meeting", 80000, 1));
//        mLists.add(new ListScheduleModel("2", "Melissa", "Monday", "Kalkulus 1","11:30", "12:00","1 hour", "Informatics", "Telkom University", "A week", "1 Meeting", 80000, 1));
//        mLists.add(new ListScheduleModel("3", "Claudia", "Monday", "Kalkulus 1","11:30", "12:00","1 hour", "Informatics", "Telkom University", "A week", "1 Meeting", 80000, 1));
//        mLists.add(new ListScheduleModel("4", "Yolanda", "Monday", "Kalkulus 1","11:30", "12:00","1 hour", "Informatics", "Telkom University", "A week", "1 Meeting", 80000, 1));
//        mAdapter.notifyDataSetChanged();
//    }

    private void initDummy(){

        mUser.add(new User("1", "angelamarpaung", "Angela Marpaung", "081269041213", "angelamarpaung@gmail.com", "Informatics", "https://www.google.com/search?q=woman+profile+picture&safe=strict&rlz=1C1CHBF_enID790ID790&tbm=isch&source=iu&ictx=1&fir=CyCLOnwCyrg3oM%253A%252C_InE0yIDe-ZgvM%252C_&vet=1&usg=AI4_-kSpq6v04QTVYLz_zdqnP-FS7YGyhw&sa=X&ved=2ahUKEwjStam4or7jAhXTX3wKHY--CoQQ9QEwAHoECAcQBA&biw=1360&bih=625#imgrc=CyCLOnwCyrg3oM:", "Telkom University", "F", 155000, "1526098", "2",
                mBank.add(new Bank("BRI", "123123","Kaesang Pangarep", "1"))
        ));


    }


}
