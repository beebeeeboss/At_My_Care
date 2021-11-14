package com.pharmacy.atmycare.ui.AdminLayoutFragments.HomeFragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pharmacy.atmycare.Adapter.ManageAtmxsAdapter;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAdminManageATMxsBinding;
import com.pharmacy.atmycare.databinding.FragmentAdminManageStocksBinding;
import com.pharmacy.atmycare.model.ATMX;
import com.pharmacy.atmycare.ui.AdminLayoutFragments.AdminDashboardFragment;

import java.util.ArrayList;
import java.util.List;


public class Admin_ManageATMxs_Fragment extends Fragment {

    private FragmentAdminManageATMxsBinding binding;
    private ManageAtmxsAdapter atmxsAdapter;
    private List<ATMX> atmxList;
    private DatabaseReference reference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdminManageATMxsBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AdminDashboardFragment.bindings.bnAdmin.setVisibility(View.INVISIBLE);
        reference = FirebaseDatabase.getInstance().getReference();
        atmxList = new ArrayList<>();
        binding.rvManageAtmx.setLayoutManager(new LinearLayoutManager(getContext()));
        atmxsAdapter = new ManageAtmxsAdapter(atmxList , getContext());
        binding.rvManageAtmx.setAdapter(atmxsAdapter);

        getAtmxs();
    }

    private void getAtmxs() {
        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setTitle("Please Wait");
        dialog.setMessage("Fetching Data...");
        dialog.setCancelable(false);
        dialog.show();
        reference.child("atmxlist").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful())
                {
                  for(DataSnapshot dataSnapshot : task.getResult().getChildren())
                  {
                      ATMX atmx = dataSnapshot.getValue(ATMX.class);
                      atmxList.add(atmx);
                  }
                  atmxsAdapter.notifyDataSetChanged();
                  dialog.dismiss();
                }
                else
                {
                    dialog.dismiss();
                    Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_LONG).show();
                    Navigation.findNavController(getView()).navigateUp();
                }
            }
        }).addOnCanceledListener(new OnCanceledListener() {
            @Override
            public void onCanceled() {
                dialog.dismiss();
                Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_LONG).show();
                Navigation.findNavController(getView()).navigateUp();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
                Toast.makeText(getContext() , e.getMessage() , Toast.LENGTH_LONG).show();
                Navigation.findNavController(getView()).navigateUp();
            }
        });
    }
}