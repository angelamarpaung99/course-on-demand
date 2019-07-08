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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.courseondemand.R;
import com.example.courseondemand.home_fragment_list.ListScheduleAdapter;
import com.example.courseondemand.home_fragment_list.ListScheduleModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDetailActivity extends AppCompatActivity {


    private List<ListScheduleModel> mLists = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private TextView tvNameDetail, tvUniversityDetail, tvLessonDetail, tvMajorDetail, tvDurationDetail, tvDayDetail, tvStartDetail, tvEndsDetail, tvPacketDetail, tvPersonDetail, tvPriceDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity_detail);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        final ListScheduleModel mData =  (ListScheduleModel)bundle.getSerializable("key");



        initToolbar();
        initComponent();
        setData(mData);

        Button btnAccept = findViewById(R.id.btnAccept);
        Button btnDecline = findViewById(R.id.btnDecline);
        btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(mData);

            }
        });
    }

    private void showDialog(final ListScheduleModel mData){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to decline this order? ");
        builder.setCancelable(false);
        builder.setPositiveButton("Decline", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteSelectedItem(mData);
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

    private void deleteSelectedItem(ListScheduleModel mData) {
        mLists.remove(mData);
    }

    public void setData(ListScheduleModel data){
        tvNameDetail.setText(data.getName());
        tvUniversityDetail.setText(data.getUniversity());
        tvLessonDetail.setText(data.getLesson());
        tvMajorDetail.setText(data.getMajor());
        tvDurationDetail.setText(data.getTeachingduration());
        tvDayDetail.setText(data.getDay());
        tvStartDetail.setText(data.getStart());
        tvEndsDetail.setText(data.getEnds());
        tvPacketDetail.setText(data.getPacket());
        tvPersonDetail.setText(Integer.toString(data.getPerson()));
        tvPriceDetail.setText(Integer.toString(data.getPrice()));
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
