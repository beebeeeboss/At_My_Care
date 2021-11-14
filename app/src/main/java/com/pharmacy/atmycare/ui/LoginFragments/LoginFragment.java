package com.pharmacy.atmycare.ui.LoginFragments;

import android.content.Context;
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
import com.pharmacy.atmycare.ui.ATMxLayoutFragments.ATMxDashboardFragment;
import com.pharmacy.atmycare.ui.StarterActivity;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    public static View loginView;
    public static Context loginContext;
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
        loginView = getView();
        loginContext = getContext();
        if(StarterActivity.type != null){
            switch (StarterActivity.type)
            {
                case "Admin":
                    Navigation.findNavController(loginView).navigate(LoginFragmentDirections.actionLoginFragmentToAdminDashboardFragment());
                    break;
                case "Atmx":
                    Navigation.findNavController(loginView).navigate(LoginFragmentDirections.actionLoginFragmentToATMxDashboardFragment());
                    break;
                case "User":
                    Navigation.findNavController(loginView).navigate(LoginFragmentDirections.actionLoginFragmentToUserDashboardFragment());
                    break;
            }
        }
        else {
            if (UserLoginFragment.goTo != null) {
                if (UserLoginFragment.goTo.equals("reg")) {
                    Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView2)).navigate(LoginFragmentDirections.actionLoginFragmentToResgisterUserFragment());
                } else if (UserLoginFragment.goTo.equals("dash")) {
                    Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView2)).navigate(LoginFragmentDirections.actionLoginFragmentToUserDashboardFragment());
                }
            } else {
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.user_type, R.layout.login_spinner_item);
                adapter.setDropDownViewResource(R.layout.spinner_dialog_item);
                binding.spLoginType.setAdapter(adapter);
                binding.spLoginType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Navigation.findNavController(binding.fragmentContainerView3).navigateUp();
                        switch (i) {
                            case 2:
                                Navigation.findNavController(binding.fragmentContainerView3).navigate(R.id.action_userLoginFragment_to_adminLoginFragment);
                                break;
                            case 1:
                                Navigation.findNavController(binding.fragmentContainerView3).navigate(R.id.action_userLoginFragment_to_ATMxLoginFragment);
                                break;
                            case 0:
                                Navigation.findNavController(binding.fragmentContainerView3).navigateUp();
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
}