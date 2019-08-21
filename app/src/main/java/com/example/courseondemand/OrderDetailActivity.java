package com.example.courseondemand;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.courseondemand.home_fragment_list.OrderResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class OrderDetailActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private String uid;
    private DocumentReference studentRef;
    private TextView tvNameDetail1, tvUniversityDetail1, tvLessonDetail1, tvMajorDetail1, tvDurationDetail1, tvDayDetail1, tvStartDetail1, tvEndsDetail1,
            tvPacketDetail1, tvPersonDetail1, tvPriceDetail1;
    private ImageView ivPersonDetail1;
    private ImageButton chatBtn, callBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_detail);

        Intent intent = this.getIntent();
        uid = intent.getStringExtra("key1");

        db = FirebaseFirestore.getInstance();
        studentRef = db.collection("orders").document(uid);

        initToolbar();

        ivPersonDetail1 = findViewById(R.id.ivPersonDetail1);
        tvNameDetail1 = findViewById(R.id.tvNameDetail1);
        tvUniversityDetail1 = findViewById(R.id.tvUniversityDetail1);
        tvLessonDetail1 = findViewById(R.id.tvLessonDetail1);
        tvMajorDetail1 = findViewById(R.id.tvMajorDetail1);
        tvDurationDetail1 = findViewById(R.id.tvDurationDetail1);
        tvDayDetail1 = findViewById(R.id.tvDayDetail1);
        tvStartDetail1 = findViewById(R.id.tvStartDetail1);
        tvEndsDetail1 = findViewById(R.id.tvEndsDetail1);
        tvPacketDetail1 = findViewById(R.id.tvPacketDetail1);
        tvPersonDetail1 = findViewById(R.id.tvPersonDetail1);
        tvPriceDetail1 = findViewById(R.id.tvPriceDetail1);

        chatBtn = findViewById(R.id.chatBtn);
        callBtn = findViewById(R.id.callBtn);

//        chatBtn.setOnClickListener(this);
//        callBtn.setOnClickListener(this);

        getStudent();
    }

    private void getStudent() {
        studentRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(final DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            final String name1 = documentSnapshot.getString("student.name");
                            final String university1 = documentSnapshot.getString("student.university");
                            final String lesson1 = documentSnapshot.getString("lesson.lessonName");
                            final String major1 = documentSnapshot.getString("student.major");
                            final String duration1 = documentSnapshot.getString("teach.teachPeriod");
                            final String day1 = documentSnapshot.getString("teach.day");
                            final String start1 = documentSnapshot.getString("teach.startTime");
                            final String ends1 = documentSnapshot.getString("teach.endTime");
                            final String packet1 = documentSnapshot.getString("packet.meeting");
                            final String person1 = documentSnapshot.getString("packet.person");
                            final String price1 = documentSnapshot.getLong("payment.price").toString();
                            final String url1 = documentSnapshot.getString("student.picture");

                            tvNameDetail1.setText(name1);
                            tvUniversityDetail1.setText(university1);
                            tvLessonDetail1.setText(lesson1);
                            tvMajorDetail1.setText(major1);
                            tvDurationDetail1.setText(duration1);
                            tvDayDetail1.setText(day1);
                            tvStartDetail1.setText(start1);
                            tvEndsDetail1.setText(ends1);
                            tvPacketDetail1.setText(packet1);
                            tvPersonDetail1.setText(person1);
                            tvPriceDetail1.setText(price1);
                            Tools.setImage(ivPersonDetail1 ,url1);
                        }
                    }
                });
    }

    public void initToolbar() {
        Toolbar toolbar = findViewById(R.id.order_detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

//    @Override
//    public void onClick(View view) {
//        if (view == callBtn){
//
//        } else if (view == chatBtn){
//
//        }
//    }
}
