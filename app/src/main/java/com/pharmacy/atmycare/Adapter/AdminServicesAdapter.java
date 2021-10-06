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
import com.pharmacy.atmycare.model.ATMxServices;
import com.pharmacy.atmycare.model.AdminServices;

import java.util.List;

public class AdminServicesAdapter extends RecyclerView.Adapter<AdminServicesAdapter.MyViewHolder> {
    private List<AdminServices> adminServiceList;
    private Context mContext;

    public AdminServicesAdapter(List<AdminServices> adminServiceList, Context context) {
        this.adminServiceList = adminServiceList;
        mContext = context;
    }

    @NonNull
    @Override
    public AdminServicesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carddesign_services , parent , false);
        return new AdminServicesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminServicesAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(adminServiceList.get(position).getServiceName());
        holder.ivSmallLogo.setImageResource(adminServiceList.get(position).getSmallLogoID());
        holder.ivBigLogo.setImageResource(adminServiceList.get(position).getBigLogoID());
    }

    @Override
    public int getItemCount() {
        return adminServiceList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivSmallLogo , ivBigLogo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvServiceName);
            ivSmallLogo = itemView.findViewById(R.id.ivLogo);
            ivBigLogo = itemView.findViewById(R.id.ivBigLogo);
        }
    }
}
