package com.pharmacy.atmycare.ui.LoginFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentUserLoginBinding;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;


public class UserLoginFragment extends Fragment {

    private FragmentUserLoginBinding binding;
    private OtpTextView otpView;
    public static String goTo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserLoginBinding.inflate(inflater ,container ,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        otpView = binding.ovReceivedOtp;
        binding.btnSendOTP.setOnClickListener(v->
        {
            if (binding.etPhoneNumber.getText().toString().length() < 10) {
                    binding.tilPhoneNumber.setError("Please Fill Valid Mobile Number");
            }
            else {
                    binding.etPhoneNumber.setEnabled(false);
                    binding.tilPhoneNumber.setVisibility(View.GONE);
                    binding.btnSendOTP.setVisibility(View.GONE);
                    binding.llOtp.setVisibility(View.VISIBLE);
                    binding.tvResendOTP.setVisibility(View.VISIBLE);
                    binding.tvChangeNumber.setVisibility(View.VISIBLE);
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
                            //go to User Register Form or Dashboard according to database
                           goTo = "reg";
                            Navigation.findNavController(getView()).navigate(R.id.action_userLoginFragment_to_nav_graph);
                    }
                else {
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