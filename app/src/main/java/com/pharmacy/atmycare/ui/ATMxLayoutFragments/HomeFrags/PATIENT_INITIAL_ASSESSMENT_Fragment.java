package com.pharmacy.atmycare.ui.ATMxLayoutFragments.HomeFrags;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentPATIENTINITIALASSESSMENTBinding;


public class PATIENT_INITIAL_ASSESSMENT_Fragment extends Fragment {

    private FragmentPATIENTINITIALASSESSMENTBinding bindings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bindings = FragmentPATIENTINITIALASSESSMENTBinding.inflate(inflater , container , false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindings.ivBackPatientInitialAssessment.setOnClickListener(v->
                Navigation.findNavController(getView()).navigateUp());
        bindings.tvNext.setOnClickListener(v->
                Navigation.findNavController(v).navigate(PATIENT_INITIAL_ASSESSMENT_FragmentDirections.actionPATIENTINITIALASSESSMENTFragmentToTheropotaticFragment())
        );

        bindings.rbSmoking.setOnClickListener(v -> {
            if(bindings.rbSmoking.isChecked())
            {
                bindings.tilSmokingStartDate.setVisibility(View.VISIBLE);
                bindings.tilSmokingFrequency.setVisibility(View.VISIBLE);
            }
            else
            {
                bindings.tilSmokingStartDate.setVisibility(View.GONE);
                bindings.tilSmokingFrequency.setVisibility(View.GONE);
            }
        });

        bindings.rbAlcohol.setOnClickListener(v -> {
            if(bindings.rbAlcohol.isChecked())
            {
                bindings.tilAlcoholStartDate.setVisibility(View.VISIBLE);
                bindings.tilAlcoholFrequency.setVisibility(View.VISIBLE);
            }
            else
            {
                bindings.tilAlcoholStartDate.setVisibility(View.GONE);
                bindings.tilAlcoholFrequency.setVisibility(View.GONE);
            }
        });

        bindings.ckAddiction.setOnClickListener(v -> {
            if(bindings.ckAddiction.isChecked())
            {
                bindings.tilAddictionStartDate.setVisibility(View.VISIBLE);
                bindings.tilAddictionFrequency.setVisibility(View.VISIBLE);
            }
            else
            {
                bindings.tilAddictionStartDate.setVisibility(View.GONE);
                bindings.tilAddictionFrequency.setVisibility(View.GONE);
            }
        });
    }
}