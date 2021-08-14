package com.pharmacy.atmycare.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.pharmacy.atmycare.Adapter.UserContentAdapter;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentUserDashboardBinding;

import java.util.ArrayList;
import java.util.List;


public class UserDashboardFragment extends Fragment {

    private FragmentUserDashboardBinding bindings;
    private UserContentAdapter mUserContentAdapter;
    private List<Integer> imageResourceList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bindings = FragmentUserDashboardBinding.inflate(inflater,container,false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageResourceList = new ArrayList<>();
        mUserContentAdapter = new UserContentAdapter(getContext() , imageResourceList );
        bindings.rvContentInUser.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        bindings.rvContentInUser.setAdapter(mUserContentAdapter);
        bindings.ivLogoutUser.setOnClickListener(v->
        {
            //here logout code should be implemented after connected to DB
        });
        imageResourceList.add(R.drawable.stethoscope);
        imageResourceList.add(R.drawable.book);
        imageResourceList.add(R.drawable.heart);
        mUserContentAdapter = new UserContentAdapter(getContext() , imageResourceList );
        mUserContentAdapter.notifyDataSetChanged();
    }
}