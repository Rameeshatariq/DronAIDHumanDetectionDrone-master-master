package com.example.cv.dronaidhumandetectiondrone;

/**
 * Created by Maham on 7/8/2018.
 */

public class Upload {
    private String date;
    private String location;
    private String mImageUrl;
    private String time;

    public Upload(){

    }

    public Upload(String dates, String locations, String mImageUrls, String times){
        date = dates;
        location=locations;
        mImageUrl = mImageUrls;
        time = times;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}