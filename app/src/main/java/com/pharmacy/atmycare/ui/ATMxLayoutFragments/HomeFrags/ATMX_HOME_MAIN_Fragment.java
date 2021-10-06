package com.pharmacy.atmycare.ui.ATMxLayoutFragments.HomeFrags;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentATMXHomeBinding;
import com.pharmacy.atmycare.databinding.FragmentATMXHomeMainBinding;
import com.pharmacy.atmycare.databinding.FragmentATMxDashboardBinding;
import com.pharmacy.atmycare.ui.ATMxLayoutFragments.ATMxDashboardFragment;


public class ATMX_HOME_MAIN_Fragment extends Fragment {
    private FragmentATMXHomeMainBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentATMXHomeMainBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ATMxDashboardFragment.binding.bnATMX.setVisibility(View.VISIBLE);
        binding.cvPATIENTATMx.setOnClickListener(v->
                {
                Navigation.findNavController(getView()).navigate(ATMX_HOME_MAIN_FragmentDirections.actionATMXHOMEMAINFragmentToPATIENTINITIALASSESSMENTFragment());
                    ATMxDashboardFragment.binding.bnATMX.setVisibility(View.GONE);
                });
    }
}