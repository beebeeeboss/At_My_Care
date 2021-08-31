package com.pharmacy.atmycare.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentUserDashboardBinding;


public class UserDashboardFragment extends Fragment {


    private FragmentUserDashboardBinding bindings;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindings  = FragmentUserDashboardBinding.inflate(inflater , container ,false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        bindings.bnUser.setOnNavigationItemSelectedListener(item ->
        {
            switch (item.getItemId()) {
                case R.id.bnHome:
                    Navigation.findNavController(bindings.fragmentContainerView).navigate(R.id.homeUserFragment);
                    return true;
                case R.id.bnCourses:
                    Navigation.findNavController(bindings.fragmentContainerView).navigate(R.id.coursesUserFragment);

                    return true;

                case R.id.bnBuyMedicines:
                    Navigation.findNavController(bindings.fragmentContainerView).navigate(R.id.buyMedicinesUserFragment);

                    return true;

                case R.id.bnNotifications:
                    Navigation.findNavController(bindings.fragmentContainerView).navigate(R.id.notificationsUserFragment);

                    return true;

                case R.id.bnAccount:
                    if(1 == 1) //TODO Here Logic of User is Logged in or not (guest )
                    {
                        //if user is logged in with account details
                        Navigation.findNavController(bindings.fragmentContainerView).navigate(R.id.accountUserFragment);
                    }
                    else
                    {
                      //guest user
                        View promptView = LayoutInflater.from(getContext()).inflate(R.layout.account_user_dailog , null);
                        AlertDialog dialog = new AlertDialog.Builder(getContext()).create();
                        Button btnCancelLogin = promptView.findViewById(R.id.btnCancelAccountUser);
                        Button btnLogin = promptView.findViewById(R.id.btnLoginAccountUser);
                        btnCancelLogin.setOnClickListener(v->
                                dialog.dismiss());
                        btnLogin.setOnClickListener(v->
                        {
                            dialog.dismiss();
                            Navigation.findNavController(getView()).navigate(UserDashboardFragmentDirections.actionUserDashboardFragmentToLoginFragment());
                        });
                        dialog.setView(promptView);
                        dialog.setCancelable(true);
                        dialog.show();
                    }
                    return true;

                default:
                    return false;
            }
        });
    }


}