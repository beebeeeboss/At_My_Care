package com.pharmacy.atmycare.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.model.ATMX;

import java.util.List;

public class ManageAtmxsAdapter extends RecyclerView.Adapter<ManageAtmxsAdapter.myViewHolder> {

    private List<ATMX> atmxList;
    private Context context;
    public ManageAtmxsAdapter(List<ATMX> atmxList , Context context) {
        this.atmxList = atmxList;
        this.context = context;

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_atmx_card,parent,false);
        return new ManageAtmxsAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ManageAtmxsAdapter.myViewHolder holder, int position) {
        ATMX atmx = atmxList.get(position);
         holder.tvName.setText(atmx.getName());
        holder.tvMobile.setText(atmx.getMobileNo()+"");
        holder.tvAddress.setText(atmx.getAddress());
        holder.tvUserId.setText(atmx.getUserid());
        holder.tvPassword.setText(atmx.getPassword());

    }

    @Override
    public int getItemCount() {
        return atmxList.size();
    }

   static class myViewHolder extends RecyclerView.ViewHolder{
        TextView tvName , tvUserId , tvMobile , tvAddress , tvPassword;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameManageAtmx);
            tvAddress = itemView.findViewById(R.id.tvAddressManageAtmx);
            tvMobile = itemView.findViewById(R.id.tvMobileNumberManageAtmx);
            tvUserId = itemView.findViewById(R.id.tvUserIdManageAtmx);
            tvPassword = itemView.findViewById(R.id.tvPasswordManageAtmx);
        }
    }
}
