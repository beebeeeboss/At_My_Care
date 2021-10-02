package com.pharmacy.atmycare.ui.ATMxLayoutFragments.HomeFrags;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentMedicationTableLayoutBinding;

public class MedicationTableLayoutFragment extends Fragment {

    public static FragmentMedicationTableLayoutBinding medicationBindings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        medicationBindings = FragmentMedicationTableLayoutBinding.inflate(inflater , container , false);
        return medicationBindings.getRoot();
    }
}