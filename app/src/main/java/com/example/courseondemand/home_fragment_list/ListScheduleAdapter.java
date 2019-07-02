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
import com.example.courseondemand.ScheduleDetailActivity;

import java.util.ArrayList;
import java.util.List;

//class yang digunakan sebagai adapter dari recycler view

public class ListScheduleAdapter extends RecyclerView.Adapter<ListScheduleAdapter.ViewHolder> {

    private List<ListScheduleModel> mLists = new ArrayList<>();
    private Context mContext;

    public ListScheduleAdapter(List<ListScheduleModel> mLists) {
        this.mLists = mLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext =viewGroup.getContext();

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.schedule_list_notes, viewGroup, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final int position = i;

        final ListScheduleModel scheduleModel = mLists.get(position);
        viewHolder.name.setText(scheduleModel.getName());
        viewHolder.lesson.setText(scheduleModel.getLesson());
        viewHolder.start.setText(scheduleModel.getStart());
        viewHolder.day.setText(scheduleModel.getDay());
        viewHolder.duration.setText(scheduleModel.getDuration());

        viewHolder.cvScheduleListNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(mContext, ScheduleDetailActivity.class);
            intent.putExtra("key", "id");
            mContext.startActivity(intent);
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

        TextView name, lesson, day,duration, start;

        public ViewHolder(@NonNull View itemView){
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
