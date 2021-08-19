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
import com.pharmacy.atmycare.model.HealthBlog_User;

import java.util.List;

public class UserHealthBlogsAdapter extends RecyclerView.Adapter<UserHealthBlogsAdapter.UserHealthDataViewHolder> {

    private Context context;
    private List<HealthBlog_User> healthDataList;
    public UserHealthBlogsAdapter(Context context , List<HealthBlog_User> healthDataList)
    {
        this.context = context;
        this.healthDataList = healthDataList;
    }
    @NonNull
    @Override
    public UserHealthBlogsAdapter.UserHealthDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_health_blog_cardview_design ,parent ,false);
        return new UserHealthDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHealthBlogsAdapter.UserHealthDataViewHolder holder, int position) {
        holder.ivHealthBlog.setImageResource(healthDataList.get(position).getImageResourceID());
        holder.tvSmallTitle.setText(healthDataList.get(position).getSmallTitle());
        holder.tvBigTitle.setText(healthDataList.get(position).getBigTitle());
        holder.tvDescription.setText(healthDataList.get(position).getDescription());
        holder.tvLikes.setText(healthDataList.get(position).getNoOfLikes()+" Likes");
    }

    @Override
    public int getItemCount() {
        return healthDataList.size();
    }
    static class UserHealthDataViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView ivHealthBlog;
        private TextView tvSmallTitle , tvBigTitle , tvDescription , tvLikes;

        public UserHealthDataViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHealthBlog = itemView.findViewById(R.id.ivHealthBlog);
            tvSmallTitle =  itemView.findViewById(R.id.tvSmallTitle);
            tvBigTitle = itemView.findViewById(R.id.tvHealthBlogBigTiltle);
            tvDescription = itemView.findViewById(R.id.tvHealthBlogDescription);
            tvLikes = itemView.findViewById(R.id.tvHealthBlogLikes);
        }
    }
}
