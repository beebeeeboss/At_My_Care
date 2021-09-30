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
//        bindings.tvNext.setOnClickListener(v->
//                );
    }
}