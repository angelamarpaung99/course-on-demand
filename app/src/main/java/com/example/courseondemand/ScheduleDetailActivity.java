package com.example.courseondemand;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.courseondemand.R;
import com.example.courseondemand.home_fragment_list.ListScheduleAdapter;
import com.example.courseondemand.home_fragment_list.ListScheduleModel;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDetailActivity extends AppCompatActivity {


    private List<ListScheduleModel> mLists = new ArrayList<>();

    private ImageView ivPersonDetail;
    private TextView tvNameDetail, tvUniversityDetail, tvLessonDetail;
    private TextView tvMajorDetail, tvDurationDetail, tvDayDetail, tvStartDetail;
    private TextView tvEndsDetail , tvPacketDetail , tvPersonDetail, tvPriceDetail ;
    private String id = getIntent().getStringExtra("key");

    public ScheduleDetailActivity(List<ListScheduleModel> mLists) {
        this.mLists = mLists;
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity_detail);


        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        ListScheduleModel data =  (ListScheduleModel)bundle.getSerializable("key");
        setData(data);
    }

    public void setData(ListScheduleModel data){
        tvNameDetail.setText(data.getName());
        tvUniversityDetail.setText(data.getUniversity());
        tvLessonDetail.setText(data.getLesson());
        tvMajorDetail.setText(data.getMajor());
        tvDurationDetail.setText(data.getDuration());
        tvDayDetail.setText(data.getDay());
        tvStartDetail.setText(data.getStart());
        tvEndsDetail.setText(data.getEnds());
        tvPacketDetail.setText(data.getPacket());
        tvPersonDetail.setText(data.getPerson());
        tvPriceDetail.setText(data.getPrice());
    }

    public void initComponent(){
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
    }


}
