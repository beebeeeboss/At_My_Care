package com.pharmacy.atmycare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pharmacy.atmycare.R;

import java.util.List;

public class UserContentAdapter extends RecyclerView.Adapter<UserContentAdapter.MyViewHolder> {

    private final Context context;
    private final List<Integer> imageResourceList;
    public UserContentAdapter(Context context , List<Integer> imageResourceList)
    {
        this.context = context;
        this.imageResourceList = imageResourceList;
    }
    @NonNull
    @Override
    public UserContentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_content_cardview_design ,parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserContentAdapter.MyViewHolder holder, int position) {
          holder.imageView.setImageResource(imageResourceList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageResourceList.size();
    }

   static class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }


    }
}
