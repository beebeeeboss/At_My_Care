package com.pharmacy.atmycare.model;

public class ATMX {
    private String name;
    private String userid;
    private String password;
    private String address;
    private long mobileNo;

    public ATMX() {
    }

    public ATMX(String name, String userid, String password, String address, long mobileNo) {
        this.name = name;
        this.userid = userid;
        this.password = password;
        this.address = address;
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public long getMobileNo() {
        return mobileNo;
    }
}
