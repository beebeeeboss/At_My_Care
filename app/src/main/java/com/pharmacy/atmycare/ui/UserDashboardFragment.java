package com.pharmacy.atmycare.ui;

import android.media.MediaPlayer;
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
import android.widget.VideoView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.pharmacy.atmycare.Adapter.UserContentAdapter;
import com.pharmacy.atmycare.Adapter.UserHealthBlogsAdapter;
import com.pharmacy.atmycare.Adapter.UserVideoAdapter;
import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.databinding.FragmentUserDashboardBinding;
import com.pharmacy.atmycare.model.HealthBlog_User;
import com.pharmacy.atmycare.model.Video_User;
import com.pharmacy.atmycare.util.VideoPreparedCallBack;

import java.util.ArrayList;
import java.util.List;


public class UserDashboardFragment extends Fragment implements VideoPreparedCallBack {

    private FragmentUserDashboardBinding bindings;
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
        bindings = FragmentUserDashboardBinding.inflate(inflater,container,false);
        return bindings.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageResourceList = new ArrayList<>();
        healthDataList = new ArrayList<>();
        videoDataList = new ArrayList<>();
        mUserContentAdapter = new UserContentAdapter(getContext() , imageResourceList );
        mUserHealthBlogsAdapter = new UserHealthBlogsAdapter(getContext() , healthDataList);
        mUserVideoAdapter = new UserVideoAdapter(getContext() , videoDataList ,this);
        bindings.rvContentInUser.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        bindings.rvHealthBlogs.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        bindings.rvVideo.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        bindings.rvContentInUser.setAdapter(mUserContentAdapter);
        bindings.rvHealthBlogs.setAdapter(mUserHealthBlogsAdapter);
        bindings.rvVideo.setAdapter(mUserVideoAdapter);
        bindings.ivLogoutUser.setOnClickListener(v->
        {
            //here logout code should be implemented after connected to DB
        });
        imageResourceList.add(R.drawable.stethoscope);
        imageResourceList.add(R.drawable.book);
        imageResourceList.add(R.drawable.heart);
        mUserContentAdapter = new UserContentAdapter(getContext() , imageResourceList );
        mUserContentAdapter.notifyDataSetChanged();

        healthDataList.add(new HealthBlog_User(R.drawable.stethoscope , "Stethoscope",15,"STETHOSCOPE","This is use for listening heartbeat."));
        healthDataList.add(new HealthBlog_User(R.drawable.book , "Book",25,"KNOWLEDGE OCEAN","This is the source of knowledge."));
        healthDataList.add(new HealthBlog_User(R.drawable.heart , "Heart",10,"HEART PUMPING ORGAN","This is use for pumping blood in Body through arteries and veins."));

        mUserHealthBlogsAdapter.notifyDataSetChanged();

      videoDataList.add(new Video_User("https://cdn.videvo.net/videvo_files/video/free/2015-09/small_watermarked/Search_Google_preview.webm","Mind Over Matters",15,"Body Dysmorphia"));
        videoDataList.add(new Video_User("https://youtu.be/Y3sOM_yz6Fo","Nutrition in Helathy Life",24,"Nutrition in Helathy LifeNutrition in Helathy Life"));
        videoDataList.add(new Video_User("https://www.youtube.com/watch?v=zSguDQRjZv0","Determinants of Helath",32,"Determinants of Helath"));

        mUserVideoAdapter.notifyDataSetChanged();
        forContent = new CountDownTimer(15000,5000) {
            @Override
            public void onTick(long millisUntilFinished) {
                bindings.rvContentInUser.scrollToPosition(count++);
                bindings.rvHealthBlogs.scrollToPosition(count++);
            }

            @Override
            public void onFinish() {
                count = 0;
                bindings.rvContentInUser.scrollToPosition(0);
                bindings.rvHealthBlogs.scrollToPosition(0);
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

    @Override
    public void videoHasPrepared(VideoView view, MediaPlayer mp) {
        view.start();
    }
}