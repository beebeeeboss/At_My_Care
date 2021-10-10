package com.pharmacy.atmycare.ui.LoginFragments;

import android.app.ProgressDialog;
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
    private CountDownTimer countDownTimer;
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
                final Connection[] c = {StarterActivity.takeConnection()};
                progressDialog = new ProgressDialog(getContext());
                progressDialog.setTitle("Please Wait...");
                progressDialog.setMessage("Signing in...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                String receivedUsername = bindings.etAdminUserId.getText().toString();
                String receivedPassword = bindings.etAdminPassward.getText().toString();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        while(c[0] == null) {
                            c[0] = StarterActivity.takeConnection();
                        }
                        try {
                            Statement statement = c[0].createStatement();
                            ResultSet resultSet = statement.executeQuery("SELECT * FROM pharmaschema.\"Admin\" WHERE username='"+receivedUsername+"' AND password='"+receivedPassword+"'");
                            while(resultSet.next())
                            {
                                canGotoDashBoard = true;
                                progressDialog.dismiss();

                            }
                            countDownTimer.start();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                            countDownTimer.start();
                            progressDialog.dismiss();
                        }
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
                countDownTimer = new CountDownTimer(1,1) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        if(canGotoDashBoard)
                     goToDashBoard();
                        else {
                            progressDialog.dismiss();
                            showIncorrectCrediantials();
                        }
                    }
                };
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
}