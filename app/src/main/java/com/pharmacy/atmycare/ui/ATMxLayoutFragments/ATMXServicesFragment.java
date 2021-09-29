package com.pharmacy.atmycare.ui.ATMxLayoutFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharmacy.atmycare.Adapter.UserContentAdapter;
import com.pharmacy.atmycare.Adapter.UserHealthBlogsAdapter;
import com.pharmacy.atmycare.Adapter.UserVideoAdapter;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentATMXServicesBinding;
import com.pharmacy.atmycare.model.HealthBlog_User;
import com.pharmacy.atmycare.model.Video_User;

import java.util.List;

public class ATMXServicesFragment extends Fragment {

    private FragmentATMXServicesBinding binding;
    private UserContentAdapter mUserContentAdapter;
    private UserHealthBlogsAdapter mUserHealthBlogsAdapter;

    private UserVideoAdapter mUserVideoAdapter;
    private List<Integer> imageResourceList;
    private List<HealthBlog_User> healthDataList;

    private List<Video_User> videoDataList;
    private CountDownTimer forContent;
    private int count = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentATMXServicesBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}