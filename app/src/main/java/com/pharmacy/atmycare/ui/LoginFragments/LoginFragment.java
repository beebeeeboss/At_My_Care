package com.pharmacy.atmycare.ui.LoginFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentLoginBinding;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    // use this binding for find view by id purpose
    // like textview as binding.idnamedefinedinresourcefile
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (UserLoginFragment.goTo != null){
            if (UserLoginFragment.goTo.equals("reg")) {
                Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView2)).navigate(LoginFragmentDirections.actionLoginFragmentToResgisterUserFragment());
            } else if (UserLoginFragment.goTo.equals("dash")) {
                Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView2)).navigate(LoginFragmentDirections.actionLoginFragmentToUserDashboardFragment());
            }
        } else {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.user_type, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            binding.spLoginType.setAdapter(adapter);
            binding.fragmentContainerView3.setVisibility(View.GONE);
            binding.spLoginType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    switch (i) {
                        case 1:
                            binding.fragmentContainerView3.setVisibility(View.VISIBLE);
                            Navigation.findNavController(binding.fragmentContainerView3).navigateUp();
                            Navigation.findNavController(binding.fragmentContainerView3).navigate(UserLoginFragmentDirections.actionUserLoginFragmentToAdminLoginFragment());
                            break;
                        case 2:
                            binding.fragmentContainerView3.setVisibility(View.VISIBLE);
                            Navigation.findNavController(binding.fragmentContainerView3).navigateUp();
                            Navigation.findNavController(binding.fragmentContainerView3).navigate(UserLoginFragmentDirections.actionUserLoginFragmentToATMxLoginFragment());
                            break;
                        case 3:
                            binding.fragmentContainerView3.setVisibility(View.VISIBLE);
                            Navigation.findNavController(binding.fragmentContainerView3).navigateUp();
                            Navigation.findNavController(binding.fragmentContainerView3).navigate(UserLoginFragmentDirections.actionUserLoginFragmentSelf());
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }
}