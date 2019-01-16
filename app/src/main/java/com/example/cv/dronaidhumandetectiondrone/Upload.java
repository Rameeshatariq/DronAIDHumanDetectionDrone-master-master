package com.example.cv.dronaidhumandetectiondrone;

/**
 * Created by Maham on 7/8/2018.
 */

public class Upload {
    private String date;
    private String latitude;
    private String longitude;
    private String mImageUrl;
    private String time;

    public Upload(){

    }

    public Upload(String dates, String latitudes, String longitudes, String mImageUrls, String times){
        date = dates;
        latitude = latitudes;
        longitude = longitudes;
        mImageUrl = mImageUrls;
        time = times;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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