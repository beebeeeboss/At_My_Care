package com.pharmacy.atmycare.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pharmacy.atmycare.Adapter.CoursesAdapter;
import com.pharmacy.atmycare.model.Courses_User;

import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentAccountUserBinding;
import com.pharmacy.atmycare.databinding.FragmentCoursesUserBinding;

import java.util.ArrayList;
import java.util.List;

public class CoursesUserFragment extends Fragment {

    private FragmentCoursesUserBinding bindings;
    private CoursesAdapter mCoursesAdapter;
    private List<Courses_User> coursesDataList;
    private CountDownTimer forContent;
    private int count = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindings = FragmentCoursesUserBinding.inflate(inflater , container , false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        coursesDataList=new ArrayList<>();
        mCoursesAdapter = new CoursesAdapter(getContext() ,coursesDataList );
        bindings.rv.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        bindings.rv.setAdapter(mCoursesAdapter);
        coursesDataList.add(new Courses_User(R.drawable.account , "StethoscopeCourse",3.5,678,"This is to learn for listening heartbeat."));
        coursesDataList.add(new Courses_User(R.drawable.courses,"bookCourse",4.2,786,"tis course is to read books"));
        coursesDataList.add(new Courses_User(R.drawable.cart,"heartCourse",4.4,7286,"tis course is to read earts"));

        mCoursesAdapter.notifyDataSetChanged();

        forContent = new CountDownTimer(15000,5000) {
            @Override
            public void onTick(long millisUntilFinished) {

                bindings.rv.scrollToPosition(count++);
            }

            @Override
            public void onFinish() {
                count = 0;

                bindings.rv.scrollToPosition(0);
                forContent.start();
            }
        };
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                forContent.start();
            }
        },8000);

    }
    }
