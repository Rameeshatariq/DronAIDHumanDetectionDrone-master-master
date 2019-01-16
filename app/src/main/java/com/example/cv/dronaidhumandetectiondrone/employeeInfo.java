package com.example.cv.dronaidhumandetectiondrone;

public class employeeInfo {

    public String type;
    public String name;
    public String cnic;
    public String contactNumber;
    public String uid;
    public String img;

    public employeeInfo(){

    }

    public employeeInfo(String uid, String type, String username, String cnicno, String userphonenumber,String img) {
        this.type = type;
        this.name = username;
        this.cnic = cnicno;
        this.contactNumber = userphonenumber;
        this.uid=uid;
        this.img=img;


    }
}
