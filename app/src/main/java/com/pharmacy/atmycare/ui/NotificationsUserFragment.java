package com.pharmacy.atmycare.ui;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAccountUserBinding;
import com.pharmacy.atmycare.databinding.FragmentNotificationsUserBinding;

public class NotificationsUserFragment extends Fragment {

    private FragmentNotificationsUserBinding bindings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //bindings = FragmentNotificationsUserBinding.inflate(inflater , container , false);
      //  return bindings.getRoot();
        return inflater.inflate(R.layout.dilog_fragment,container,false);
        //return  bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    }
