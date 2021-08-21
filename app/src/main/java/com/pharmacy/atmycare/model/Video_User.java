package com.pharmacy.atmycare.model;

public class Video_User {

    private String videoResourceURL;
    private String smallTitle;
    private int noOfLikes;
    private String bigTitle;

    public Video_User(String videoResourceURL, String smallTitle, int noOfLikes, String bigTitle) {
        this.videoResourceURL = videoResourceURL;
        this.smallTitle = smallTitle;
        this.noOfLikes = noOfLikes;
        this.bigTitle = bigTitle;

    }

    public String getVideoResourceURL() {
        return videoResourceURL;
    }

    public void setVideoResourceURL(String videoResourceURL) {
        this.videoResourceURL = videoResourceURL;
    }

    public String getSmallTitle() {
        return smallTitle;
    }

    public void setSmallTitle(String smallTitle) {
        this.smallTitle = smallTitle;
    }

    public int getNoOfLikes() {
        return noOfLikes;
    }

    public void setNoOfLikes(int noOfLikes) {
        this.noOfLikes = noOfLikes;
    }

    public String getBigTitle() {
        return bigTitle;
    }

    public void setBigTitle(String bigTitle) {
        this.bigTitle = bigTitle;
    }
}

