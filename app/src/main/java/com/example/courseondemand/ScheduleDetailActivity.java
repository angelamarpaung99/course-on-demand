package com.example.courseondemand;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.courseondemand.R;
import com.example.courseondemand.home_fragment_list.ListScheduleAdapter;
import com.example.courseondemand.home_fragment_list.ListScheduleModel;
import com.example.courseondemand.home_fragment_list.OrderResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firestore.v1beta1.StructuredQuery;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDetailActivity extends AppCompatActivity {


//    private ArrayList<OrderResponse> mData = new ArrayList<>();
    private OrderResponse mData;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private TextView tvNameDetail, tvUniversityDetail, tvLessonDetail, tvMajorDetail, tvDurationDetail, tvDayDetail, tvStartDetail, tvEndsDetail, tvPacketDetail, tvPersonDetail, tvPriceDetail;
    private String uid;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity_detail);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        mData =  (OrderResponse) bundle.getSerializable("key");

        uid = bundle.getString("key");

        db = FirebaseFirestore.getInstance();

        initToolbar();
        initComponent();
        setData(mData);

        Button btnAccept = findViewById(R.id.btnAccept);
        Button btnDecline = findViewById(R.id.btnDecline);
//        btnDecline.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog(mData);
//
//            }
//        });
    }

//    private ArrayList<OrderResponse> getData(String uid) {
//        CollectionReference order = db.collection("orders");
//        order.whereEqualTo("student.UID", uid)
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
//                            OrderResponse detail = documentSnapshot.toObject(OrderResponse.class);
//                            mLists.add(detail);
//                        }
//                    }
//                });
//        mAdapter.notifyDataSetChanged();
//        return mLists;
//    }
//



    private void showDialog(final OrderResponse mData){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to decline this order? ");
        builder.setCancelable(false);
        builder.setPositiveButton("Decline", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                deleteSelectedItem(mData);
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();

    }

//    private void deleteSelectedItem(OrderResponse mData) {
//        mData.remove(mData);}


    public void setData(OrderResponse mData){
        tvNameDetail.setText(mData.student);
        tvUniversityDetail.setText();
        tvLessonDetail.setText();
        tvMajorDetail.setText();
        tvDurationDetail.setText();
        tvDayDetail.setText();
        tvStartDetail.setText();
        tvEndsDetail.setText();
        tvPacketDetail.setText();
        tvPersonDetail.setText();
        tvPriceDetail.setText();
    }

    public void initComponent(){
//        ivPersonDetail = findViewById(R.id.ivPersonDetail);
        tvNameDetail = findViewById(R.id.tvNameDetail);
        tvUniversityDetail = findViewById(R.id.tvUniversityDetail);
        tvLessonDetail = findViewById(R.id.tvLessonDetail);
        tvMajorDetail = findViewById(R.id.tvMajorDetail);
        tvDurationDetail = findViewById(R.id.tvDurationDetail);
        tvDayDetail = findViewById(R.id.tvDayDetail);
        tvStartDetail = findViewById(R.id.tvStartDetail);
        tvEndsDetail = findViewById(R.id.tvEndsDetail);
        tvPacketDetail = findViewById(R.id.tvPacketDetail);
        tvPersonDetail = findViewById(R.id.tvPersonDetail);
        tvPriceDetail = findViewById(R.id.tvPriceDetail);
    }

    public void initToolbar() {
        Toolbar toolbar = findViewById(R.id.schedule_detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
