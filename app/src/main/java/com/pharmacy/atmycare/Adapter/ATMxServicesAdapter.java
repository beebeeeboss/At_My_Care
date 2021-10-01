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

import java.util.List;
import java.util.zip.Inflater;

public class ATMxServicesAdapter extends RecyclerView.Adapter<ATMxServicesAdapter.MyViewHolder> {
    private List<ATMxServices> atmxServiceList;
    private Context mContext;
    public ATMxServicesAdapter(List<ATMxServices> atmxServiceList , Context context) {
        this.atmxServiceList = atmxServiceList;
        mContext = context;
    }

    @NonNull
    @Override
    public ATMxServicesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carddesign_services , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ATMxServicesAdapter.MyViewHolder holder, int position) {

        holder.tvName.setText(atmxServiceList.get(position).getServiceName());
        holder.ivSmallLogo.setImageResource(atmxServiceList.get(position).getSmallLogoID());
        holder.ivBigLogo.setImageResource(atmxServiceList.get(position).getBigLogoID());
    }

    @Override
    public int getItemCount() {
        return atmxServiceList.size();
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
