package com.pharmacy.atmycare.ui.LoginFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAdminLoginBinding;


public class AdminLoginFragment extends Fragment {

    private FragmentAdminLoginBinding bindings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bindings = FragmentAdminLoginBinding.inflate(inflater , container ,  false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindings.btnAdminLogin.setOnClickListener(v->
        {
            if (bindings.etAdminUserId.getText().toString().equals("")) {
                bindings.AdminUserId.setError("Please Fill Valid Username");
            }
            else if(bindings.etAdminPassward.getText().toString().equals(""))
            {
                bindings.AdminPassward.setError("Password can't be empty");
            }
            else {
                //checking credentials from server
                if(bindings.etAdminUserId.getText().toString().equals("Param") && bindings.etAdminPassward.getText().toString().equals("param123"))
                {
                    Navigation.findNavController(LoginFragment.loginView).navigate(LoginFragmentDirections.actionLoginFragmentToAdminDashboardFragment());
                }
                else
                {
                    bindings.etAdminPassward.setText("");
                    bindings.etAdminUserId.setText("");
                    bindings.AdminUserId.setError("Username must be correct");
                    bindings.AdminPassward.setError("Password not match");
                }
            }
        });
    }
}