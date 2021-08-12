package com.pharmacy.atmycare.ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
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
    private  OtpTextView otpView;
    // use this binding for find view by id purpose
    // like textview as binding.idnamedefinedinresourcefile
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext() , R.array.user_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spLoginType.setAdapter(adapter);
         otpView = binding.ovReceivedOtp;
        binding.btnSendOTP.setOnClickListener(v->
        {
            if(binding.spLoginType.getSelectedItemPosition() == 0)
            {
                Snackbar.make(getView(),"Please Select Your Role First.",Snackbar.LENGTH_LONG).show();
            }
            else {
                if (binding.etPhoneNumber.getText().toString().length() < 10) {
                    binding.tilPhoneNumber.setError("Please Fill Valid Mobile Number");
                } else {
                    binding.etPhoneNumber.setEnabled(false);
                    binding.tilPhoneNumber.setVisibility(View.GONE);
                    binding.btnSendOTP.setVisibility(View.GONE);
                    binding.llOtp.setVisibility(View.VISIBLE);
                    binding.tvResendOTP.setVisibility(View.VISIBLE);
                    binding.tvChangeNumber.setVisibility(View.VISIBLE);

                }
            }
        });

        otpView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {

            }

            @Override
            public void onOTPComplete(String otp) {
                if (otpView.getOTP().equals("123456")) {
                    otpView.showSuccess();
                    switch (binding.spLoginType.getSelectedItemPosition()) {
                        case 1:
                            //go to admin
                            break;
                        case 2:
                            //go to ATMx Register Form or Dashboard according to database
                            break;
                        case 3:
                            //go to User Register Form or Dashboard according to database
                            Navigation.findNavController(getView()).navigate(LoginFragmentDirections.actionLoginFragmentToResgisterUserFragment());
                            break;
                    }
                } else {
                    otpView.showError();
                }
            }
        });

        binding.tvChangeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etPhoneNumber.setEnabled(true);
                binding.tilPhoneNumber.setVisibility(View.VISIBLE);
                binding.btnSendOTP.setVisibility(View.VISIBLE);
                binding.llOtp.setVisibility(View.GONE);
                binding.tvResendOTP.setVisibility(View.GONE);
                binding.tvChangeNumber.setVisibility(View.GONE);
            }
        });

        binding.tvResendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpView.setOTP("");
            }
        });
    }
}