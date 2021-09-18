package com.pharmacy.atmycare.ui.ATMxLayoutFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentATMxDashboardBinding;
import com.pharmacy.atmycare.databinding.FragmentATMxLoginBinding;


public class ATMxDashboardFragment extends Fragment {

    private FragmentATMxDashboardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentATMxDashboardBinding.inflate(inflater , container ,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.bnATMX.setOnNavigationItemSelectedListener(item ->
        {
            switch (item.getItemId()) {
                case R.id.bnATMXHome:
                    Navigation.findNavController(binding.fragmentContainerView4).navigate(R.id.ATMXHomeFragment);
                    return true;
                case R.id.bnATMXServices:
                    Navigation.findNavController(binding.fragmentContainerView4).navigate(R.id.ATMXServicesFragment);

                    return true;

                case R.id.bnATMXAccount:
                    Navigation.findNavController(binding.fragmentContainerView4).navigate(R.id.ATMXAccountFragment2);

                    return true;
                default:
                    return false;
            }
        });
    }
}