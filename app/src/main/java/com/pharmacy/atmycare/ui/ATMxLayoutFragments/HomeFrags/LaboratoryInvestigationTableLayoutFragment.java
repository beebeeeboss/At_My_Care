package com.pharmacy.atmycare.ui.ATMxLayoutFragments.HomeFrags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentLaboratoryInvestigationTableLayoutBinding;


public class LaboratoryInvestigationTableLayoutFragment extends Fragment {
    public static FragmentLaboratoryInvestigationTableLayoutBinding laboratoryBindings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        laboratoryBindings = FragmentLaboratoryInvestigationTableLayoutBinding.inflate(inflater , container , false);
        return laboratoryBindings.getRoot();
    }
}