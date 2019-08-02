package com.example.courseondemand.home_fragment_list;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.courseondemand.R;
import com.example.courseondemand.OrderDetailActivity;
import com.example.courseondemand.Tools;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {
        private List<OrderResponse> mLists = new ArrayList<>();
        private Context mContext1;
        private String uid;

    public OrdersAdapter(List<OrderResponse> mLists) {
        this.mLists = mLists;
    }


    @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            mContext1 = parent.getContext();
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_list_notes, parent, false);
            final ViewHolder mViewHolder = new ViewHolder(view);
            return mViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            final int position = i;
            final OrderResponse scheduleModel1 = mLists.get(position);

            viewHolder.name.setText(scheduleModel1.student.name);
            viewHolder.lesson.setText(scheduleModel1.lesson.lessonName);
            viewHolder.start.setText(scheduleModel1.teach.startTime);
            viewHolder.day.setText(scheduleModel1.teach.day);
            viewHolder.duration.setText(scheduleModel1.teach.teachDuration);
            Tools.setImage(viewHolder.ivScheduleListNotes,scheduleModel1.student.picture);

            viewHolder.cvScheduleListNotes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext1, OrderDetailActivity.class);
                    uid = scheduleModel1.getId();
                    intent.putExtra("key1", uid);
                    mContext1.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mLists.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            CardView cvScheduleListNotes;
            ImageView ivScheduleListNotes;

            TextView name, lesson, day, duration, start;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                cvScheduleListNotes = itemView.findViewById(R.id.cvScheduleListNotes);
                ivScheduleListNotes = itemView.findViewById(R.id.ivScheduleListNotes);
                name = itemView.findViewById(R.id.tvName);
                lesson = itemView.findViewById(R.id.tvLesson);
                day = itemView.findViewById(R.id.tvDay);
                start = itemView.findViewById(R.id.tvStart);
                duration = itemView.findViewById(R.id.tvDuration);
            }
        }
}
