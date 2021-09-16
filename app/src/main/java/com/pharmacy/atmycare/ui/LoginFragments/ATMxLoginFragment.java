package com.pharmacy.atmycare.ui.LoginFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentATMxLoginBinding;


public class ATMxLoginFragment extends Fragment {

    private FragmentATMxLoginBinding binding ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentATMxLoginBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnAtmxLogin.setOnClickListener(v->
        {
            if (binding.etAtmXUserId.getText().toString().equals("")) {
                binding.AtmXUserId.setError("Please Fill Valid Username");
            }
            else if(binding.etAtmXPassward.getText().toString().equals(""))
            {
                binding.AtmXPassward.setError("Password can't be empty");
            }
            else {
               //checking credentials from server
                if(binding.etAtmXUserId.getText().toString().equals("Param") && binding.etAtmXPassward.getText().toString().equals("param123"))
                {
                    Navigation.findNavController(LoginFragment.loginView).navigate(LoginFragmentDirections.actionLoginFragmentToATMxDashboardFragment());
                }
                else
                {
                    binding.etAtmXPassward.setText("");
                    binding.etAtmXUserId.setText("");
                    binding.AtmXUserId.setError("Username must be correct");
                    binding.AtmXPassward.setError("Password not match");
                }
            }
        });
    }
}