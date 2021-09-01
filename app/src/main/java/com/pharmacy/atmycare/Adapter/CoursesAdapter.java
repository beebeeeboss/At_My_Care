package com.pharmacy.atmycare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pharmacy.atmycare.R;

import com.pharmacy.atmycare.model.Courses_User;

import java.util.List;


public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CoursesViewHolder> {

    private Context context;
    private List<Courses_User> coursesDataList;
    public CoursesAdapter(Context context , List<Courses_User> coursesDataList)
    {
        this.context = context;
        this.coursesDataList = coursesDataList;
    }
    @NonNull
    @Override
    public CoursesAdapter.CoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_cardview_design ,parent ,false);
        return new CoursesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesAdapter.CoursesViewHolder holder, int position) {
        holder.ivCourse.setImageResource(coursesDataList.get(position).getImageResourceID());
        holder.tvCourseName.setText(coursesDataList.get(position).getCourseName());
        holder.tvCost.setText(coursesDataList.get(position).getCost()+"");
        holder.tvDescription.setText(coursesDataList.get(position).getDescription());
        holder.tvStar.setText(coursesDataList.get(position).getNoOfStars()+" Stars");
    }

    @Override
    public int getItemCount() {
        return coursesDataList.size();
    }
    static class CoursesViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView ivCourse;
        private TextView tvCourseName , tvCost , tvDescription , tvStar;

        public CoursesViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCourse = itemView.findViewById(R.id.ivCourse);
            tvCourseName =  itemView.findViewById(R.id.tvCourseName);
            tvCost = itemView.findViewById(R.id.tvCost);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvStar = itemView.findViewById(R.id.tvStar);
        }
    }
    {
}}
