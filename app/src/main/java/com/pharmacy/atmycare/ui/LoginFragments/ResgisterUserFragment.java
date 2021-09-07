package com.pharmacy.atmycare.ui.LoginFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.pharmacy.atmycare.R;

import com.pharmacy.atmycare.databinding.FragmentResgisterUserBinding;


public class ResgisterUserFragment extends Fragment {
    private FragmentResgisterUserBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentResgisterUserBinding.inflate(inflater ,container,false);
        return binding.getRoot();



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ibBackFromRegisterUser.setOnClickListener(v->
                Navigation.findNavController(v).navigateUp());
        binding.btnRegisterUser.setOnClickListener(v->
                Navigation.findNavController(v).navigate(ResgisterUserFragmentDirections.actionResgisterUserFragmentToUserDashboardFragment()));
    }
}



