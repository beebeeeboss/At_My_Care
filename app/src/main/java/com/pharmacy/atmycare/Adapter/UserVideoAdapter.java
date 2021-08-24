package com.pharmacy.atmycare.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.pharmacy.atmycare.R;
import com.pharmacy.atmycare.model.Video_User;

import java.util.List;

public class UserVideoAdapter extends RecyclerView.Adapter<UserVideoAdapter.UserVideoViewHolder>  {

    private Context context;
    private List<Video_User> videoHealthDataList;
    public UserVideoAdapter(Context context, List<Video_User> videoHealthDataList) {
        this.context = context;
        this.videoHealthDataList = videoHealthDataList;

    }

    @NonNull
    @Override
    public UserVideoAdapter.UserVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_video_cardview_design, parent, false);
        return new UserVideoAdapter.UserVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserVideoAdapter.UserVideoViewHolder holder, int position) {

        try {
            holder.vvVideoVlog.loadUrl(videoHealthDataList.get(position).getVideoResourceURL());

        } catch (Exception e) {
            System.out.println("Video Play Error :" + e.getMessage());
        }
        holder.vtvSmallTitle.setText(videoHealthDataList.get(position).getSmallTitle());
        holder.vtvBigTitle.setText(videoHealthDataList.get(position).getBigTitle());

        holder.vtvLikes.setText(videoHealthDataList.get(position).getNoOfLikes()+" Likes");
    }

    @Override
    public int getItemCount() { return videoHealthDataList.size();}

    public static class UserVideoViewHolder extends RecyclerView.ViewHolder {
        private WebView vvVideoVlog;
        private TextView vtvSmallTitle , vtvBigTitle, vtvLikes;

        public UserVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            vvVideoVlog = itemView.findViewById(R.id.vvVideoBlog);
            vtvSmallTitle = itemView.findViewById(R.id.vtvSmallTitle);
            vtvBigTitle = itemView.findViewById(R.id.vtvHealthBlogBigTiltle);
            vtvLikes = itemView.findViewById(R.id.vtvHealthBlogLikes);
            vvVideoVlog.getSettings().setJavaScriptEnabled(true);
            vvVideoVlog.setWebViewClient(new WebViewClient());
            vvVideoVlog.setWebChromeClient(new WebChromeClient());
        }
    }
}
