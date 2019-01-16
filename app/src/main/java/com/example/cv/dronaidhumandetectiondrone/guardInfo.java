package com.example.cv.dronaidhumandetectiondrone;

public class guardInfo {

    public String type;
    public String name;
    public String cnic;
    public String contactNumber;
    public String img;


    public guardInfo (String type, String username, String cnicno, String userphonenumber,String img) {
        this.type = type;
        this.name = username;
        this.cnic = cnicno;
        this.contactNumber = userphonenumber;
        this.img=img;


    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getContactNumber() {
        return contactNumber;
    }


    public String getImg() {
        return img;
    }
}
