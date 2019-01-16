package com.example.cv.dronaidhumandetectiondrone;

public class adminInfo {

    private String name;
    private String cnic;
    private String contactNumber;
    private String img;
    private String type;

    public adminInfo(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String uid) {
        this.cnic = uid;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String phoneNumber) {
        this.contactNumber = phoneNumber;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
