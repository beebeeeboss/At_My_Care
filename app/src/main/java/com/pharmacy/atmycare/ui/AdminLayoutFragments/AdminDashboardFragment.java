package com.pharmacy.atmycare.ui.AdminLayoutFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAdminDashboardBinding;


public class AdminDashboardFragment extends Fragment {
    public  static  FragmentAdminDashboardBinding bindings;
    public static View adminDashBoardView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bindings = FragmentAdminDashboardBinding.inflate(inflater ,container , false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adminDashBoardView = getView();
        bindings.bnAdmin.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.bnAdminHome:
                        Navigation.findNavController(bindings.fragmentContainerView6).navigate(R.id.adminHomeFragment);
                        return true;
                    case R.id.bnAdminAccount:
                        Navigation.findNavController(bindings.fragmentContainerView6).navigate(R.id.adminAccountFragment);
                        return true;
                    case R.id.bnAdmimServices:
                        Navigation.findNavController(bindings.fragmentContainerView6).navigate(R.id.adminServicesFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}