package com.pharmacy.atmycare.ui.AdminLayoutFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.Adapter.ATMxServicesAdapter;
import com.pharmacy.atmycare.Adapter.AdminServicesAdapter;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAdminServicesBinding;
import com.pharmacy.atmycare.model.ATMxServices;
import com.pharmacy.atmycare.model.AdminServices;

import java.util.ArrayList;
import java.util.List;

public class AdminServicesFragment extends Fragment {

    private FragmentAdminServicesBinding bindings;
    private List<AdminServices> mAdminServicesList;
    private AdminServicesAdapter mAdminServicesAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bindings = FragmentAdminServicesBinding.inflate(inflater , container , false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdminServicesList = new ArrayList<>();
        mAdminServicesAdapter = new AdminServicesAdapter(mAdminServicesList , getContext());
        bindings.rvAdminServices.setLayoutManager(new LinearLayoutManager(getContext()));
        bindings.rvAdminServices.setAdapter(mAdminServicesAdapter);

        AdminServices photoservice = new AdminServices("Edit Photos" , R.drawable.account , R.drawable.book);
        mAdminServicesList.add(photoservice);
        mAdminServicesAdapter.notifyDataSetChanged();
    }
}