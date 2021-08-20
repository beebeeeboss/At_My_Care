package com.pharmacy.atmycare.model;

public class HealthBlog_User {
    private int imageResourceID;
    private String smallTitle ;
    private int noOfLikes;
    private String bigTitle;
    private  String description;

    public HealthBlog_User(int imageResourceID, String smallTitle, int noOfLikes, String bigTitle, String description) {
        this.imageResourceID = imageResourceID;
        this.smallTitle = smallTitle;
        this.noOfLikes = noOfLikes;
        this.bigTitle = bigTitle;
        this.description = description;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
