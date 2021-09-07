package com.pharmacy.atmycare.ui.UserLayoutFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pharmacy.atmycare.Adapter.UserContentAdapter;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAccountUserBinding;
import com.pharmacy.atmycare.databinding.FragmentBuyMedicinesUserBinding;

import java.util.ArrayList;
import java.util.List;

public class BuyMedicinesUserFragment extends Fragment {

    private FragmentBuyMedicinesUserBinding bindings;
    private UserContentAdapter adapter;
    private List<Integer> imgList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindings = FragmentBuyMedicinesUserBinding.inflate(inflater , container , false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgList = new ArrayList<>();
        adapter = new UserContentAdapter(getContext(),imgList);
        bindings.rvMedicineImg.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        bindings.rvMedicineImg.setAdapter(adapter);

        imgList.add(R.drawable.book);
        imgList.add(R.drawable.heart);
        imgList.add(R.drawable.stethoscope);
        imgList.add(R.drawable.book);

        adapter= new UserContentAdapter(getContext(),imgList);
        adapter.notifyDataSetChanged();

    }
}