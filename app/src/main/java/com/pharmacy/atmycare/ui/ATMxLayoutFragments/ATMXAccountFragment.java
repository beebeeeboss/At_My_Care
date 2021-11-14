package com.pharmacy.atmycare.ui.ATMxLayoutFragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentATMXAccountBinding;
import com.pharmacy.atmycare.ui.AdminLayoutFragments.AdminDashboardFragment;
import com.pharmacy.atmycare.ui.AdminLayoutFragments.AdminDashboardFragmentDirections;
import com.pharmacy.atmycare.ui.StarterActivity;

public class ATMXAccountFragment extends Fragment {

    private FragmentATMXAccountBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentATMXAccountBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.cvUserLogout.setOnClickListener(v->
        {
            ProgressDialog dialog = new ProgressDialog(getContext());
            dialog.setTitle("Please Wait");
            dialog.setMessage("Logging Out...");
            dialog.setCancelable(false);
            dialog.show();

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
            if(sharedPreferences != null) {
                sharedPreferences.edit().clear().apply();
                dialog.dismiss();
                StarterActivity.type = null;
                Navigation.findNavController(ATMxDashboardFragment.atmxDashboardView).navigate(ATMxDashboardFragmentDirections.actionATMxDashboardFragmentToLoginFragment());
            }
        });
    }
}