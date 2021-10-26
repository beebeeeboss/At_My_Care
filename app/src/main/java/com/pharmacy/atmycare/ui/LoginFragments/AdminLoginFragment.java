package com.pharmacy.atmycare.ui.LoginFragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAdminLoginBinding;
import com.pharmacy.atmycare.ui.StarterActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;


public class AdminLoginFragment extends Fragment {

    private FragmentAdminLoginBinding bindings;
    private boolean canGotoDashBoard = false;
    private ProgressDialog progressDialog;

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

                progressDialog = new ProgressDialog(getContext());
                progressDialog.setTitle("Please Wait...");
                progressDialog.setMessage("Signing in...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                String receivedUsername = bindings.etAdminUserId.getText().toString();
                String receivedPassword = bindings.etAdminPassward.getText().toString();
                StarterActivity.auth.signInWithEmailAndPassword(receivedUsername , receivedPassword).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            doEntryOnSharedPreferences();
                            goToDashBoard();
                        }
                        else
                        {
                            showIncorrectCrediantials();
                        }
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        progressDialog.dismiss();
                        Toast.makeText(LoginFragment.loginContext,"Please Check Your Internet Connection", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void goToDashBoard()
    {
        Navigation.findNavController(LoginFragment.loginView).navigate(LoginFragmentDirections.actionLoginFragmentToAdminDashboardFragment());
    }
    private void showIncorrectCrediantials()
    {
        bindings.etAdminPassward.setText("");
        bindings.etAdminUserId.setText("");
        bindings.AdminUserId.setError("Username must be correct");
        bindings.AdminPassward.setError("Password not match");
    }

    private void doEntryOnSharedPreferences()
    {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("type","Admin");
        editor.putString("username",bindings.etAdminUserId.getText().toString());
        editor.putString("password",bindings.etAdminPassward.getText().toString());
        editor.commit();
    }
}