package com.example.cv.dronaidhumandetectiondrone;

public class notification {
    private String date;
    private String location;
    private String time;
    private String mImage;

    public notification(){

    }

    public notification(String dates, String locations, String mImages, String times){
        date = dates;
        location=locations;
        time = times;
        mImage = mImages;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMImage() {
        return mImage;
    }

    public void setMImage(String mImage) {
        this.mImage = mImage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
