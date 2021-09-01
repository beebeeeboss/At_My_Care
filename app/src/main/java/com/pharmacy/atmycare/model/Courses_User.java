package com.pharmacy.atmycare.model;

public class Courses_User {

        private int ivCourse;
        private String tvCourseName ;
        private double tvStar;
        private int tvCost;
        private  String description;

        public Courses_User(int ivCourse, String tvCourseName, double tvStar, int tvCost, String description) {
            this.ivCourse = ivCourse;
            this.tvCourseName = tvCourseName;
            this.tvStar = tvStar;
            this.tvCost = tvCost;
            this.description = description;
        }

        public int getImageResourceID() {
            return ivCourse;
        }

        public void setImageResourceID(int imageResourceID) {
            this.ivCourse = imageResourceID;
        }

        public String getCourseName() {
            return tvCourseName ;
        }

        public void setCourseName(String smallTitle) {
            this.tvCourseName = smallTitle;
        }

        public double getNoOfStars() {

            return tvStar;
        }

        public void setNoOfStars(double noOfLikes) {

            this.tvStar = noOfLikes;
        }

        public int getCost() {
            return tvCost;
        }

        public void setCost(int bigTitle) {
            this.tvCost = bigTitle;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


