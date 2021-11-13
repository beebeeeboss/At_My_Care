package com.pharmacy.atmycare.ui.AdminLayoutFragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.databinding.FragmentAdminAccountBinding;
import com.pharmacy.atmycare.ui.LoginFragments.AdminLoginFragment;
import com.pharmacy.atmycare.ui.StarterActivity;

public class AdminAccountFragment extends Fragment {

    private FragmentAdminAccountBinding bindings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bindings = FragmentAdminAccountBinding.inflate(inflater , container , false);
        return bindings.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindings.cvUserLogout.setOnClickListener(v->
                logout()
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    private void logout() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Logging out....");
        progressDialog.show();
        StarterActivity.auth.signOut();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        if(sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
            progressDialog.dismiss();
            StarterActivity.type = null;
            Navigation.findNavController(AdminDashboardFragment.adminDashBoardView).navigate(AdminDashboardFragmentDirections.actionAdminDashboardFragmentToLoginFragment());
        }
    }
}