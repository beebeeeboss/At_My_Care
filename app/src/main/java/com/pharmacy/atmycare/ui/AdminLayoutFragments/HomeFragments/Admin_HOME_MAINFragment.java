package com.pharmacy.atmycare.ui.AdminLayoutFragments.HomeFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAdminHOMEMAINBinding;
import com.pharmacy.atmycare.ui.AdminLayoutFragments.AdminDashboardFragment;


public class Admin_HOME_MAINFragment extends Fragment {

    private FragmentAdminHOMEMAINBinding bindings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bindings = FragmentAdminHOMEMAINBinding.inflate(inflater , container , false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AdminDashboardFragment.bindings.bnAdmin.setVisibility(View.VISIBLE);
        bindings.cvAdminAddATMx.setOnClickListener(v->
                Navigation.findNavController(v).navigate(Admin_HOME_MAINFragmentDirections.actionAdminHOMEMAINFragmentToAddNewATMXFragment()));
        bindings.cvAdminManageATMx.setOnClickListener(v->
                Navigation.findNavController(v).navigate(Admin_HOME_MAINFragmentDirections.actionAdminHOMEMAINFragmentToAdminManageATMxsFragment()));
    }
}