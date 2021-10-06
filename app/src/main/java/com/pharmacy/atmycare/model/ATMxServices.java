package com.pharmacy.atmycare.model;

public class ATMxServices {
    private String serviceName;
    private int smallLogoID , bigLogoID;

    public ATMxServices(String serviceName, int smallLogoID, int bigLogoID) {
        this.serviceName = serviceName;
        this.smallLogoID = smallLogoID;
        this.bigLogoID = bigLogoID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getSmallLogoID() {
        return smallLogoID;
    }

    public void setSmallLogoID(int smallLogoID) {
        this.smallLogoID = smallLogoID;
    }

    public int getBigLogoID() {
        return bigLogoID;
    }

    public void setBigLogoID(int bigLogoID) {
        this.bigLogoID = bigLogoID;
    }
}
