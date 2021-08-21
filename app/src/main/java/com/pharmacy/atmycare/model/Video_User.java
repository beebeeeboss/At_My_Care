package com.pharmacy.atmycare.model;

public class Video_User {

    private int videoResourceID;
    private String smallTitle;
    private int noOfLikes;
    private String bigTitle;

    public Video_User(int videoResourceID, String smallTitle, int noOfLikes, String bigTitle) {
        this.videoResourceID = videoResourceID;
        this.smallTitle = smallTitle;
        this.noOfLikes = noOfLikes;
        this.bigTitle = bigTitle;

    }

    public int getVideoResourceID() {
        return videoResourceID;
    }

    public void setVideoResourceID(int videoResourceID) {
        this.videoResourceID = videoResourceID;
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

