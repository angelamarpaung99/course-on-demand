package com.example.courseondemand;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.courseondemand.home_fragment_list.OrderResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.support.constraint.Constraints.TAG;

public class ScheduleDetailActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private String uid;
    private DocumentReference studentRef;
    private TextView tvNameDetail, tvUniversityDetail, tvLessonDetail, tvMajorDetail, tvDurationDetail, tvDayDetail, tvStartDetail, tvEndsDetail,
            tvPacketDetail, tvPersonDetail, tvPriceDetail;
    private ImageView ivPersonDetail;
    private OrderResponse order;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity_detail);

        Intent intent = this.getIntent();
        uid = intent.getStringExtra("key");

        db = FirebaseFirestore.getInstance();
        studentRef = db.collection("orders").document(uid);

        initToolbar();

        ivPersonDetail = findViewById(R.id.ivPersonDetail);
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

        getStudent();

        Button btnAccept = findViewById(R.id.btnAccept);
        Button btnDecline = findViewById(R.id.btnDecline);


        btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void getStudent() {
        studentRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(final DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            final String name = documentSnapshot.getString("student.name");
                            final String university = documentSnapshot.getString("student.university");
                            final String lesson = documentSnapshot.getString("lesson.lessonName");
                            final String major = documentSnapshot.getString("student.major");
                            final String duration = documentSnapshot.getString("teach.teachPeriod");
                            final String day = documentSnapshot.getString("teach.day");
                            final String start = documentSnapshot.getString("teach.startTime");
                            final String ends = documentSnapshot.getString("teach.endTime");
                            final String packet = documentSnapshot.getString("packet.meeting");
                            final String person = documentSnapshot.getString("packet.person");
                            final String price = documentSnapshot.getLong("payment.price").toString();
                            final String url = documentSnapshot.getString("student.picture");

                            tvNameDetail.setText(name);
                            tvUniversityDetail.setText(university);
                            tvLessonDetail.setText(lesson);
                            tvMajorDetail.setText(major);
                            tvDurationDetail.setText(duration);
                            tvDayDetail.setText(day);
                            tvStartDetail.setText(start);
                            tvEndsDetail.setText(ends);
                            tvPacketDetail.setText(packet);
                            tvPersonDetail.setText(person);
                            tvPriceDetail.setText(price);
                            Tools.setImage(ivPersonDetail ,url);

                            Button btnAccept = findViewById(R.id.btnAccept);
                            Button btnDecline = findViewById(R.id.btnDecline);
                            btnAccept.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    studentRef.update("status", 1);
                                    Intent intent = new Intent(ScheduleDetailActivity.this, HomeNotActive.class);
                                    startActivity(intent);
                                }
                            });
                            btnDecline.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    showDialog();
                                }
                            });

                        }
                    }
                });
    }


    private void showDialog(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to decline this order? ");
        builder.setCancelable(false);
        builder.setPositiveButton("Decline", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteSelectedItem();
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

    private void deleteSelectedItem() {
        studentRef.delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Order successfully declined!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error declining order!", e);
                    }
                });
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
