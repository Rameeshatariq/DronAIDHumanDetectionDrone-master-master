package com.example.cv.dronaidhumandetectiondrone;

public class notification {
    private String date;
    private String latitude;
    private String longitude;
    private String time;
    private String mImage;

    public notification(){

    }

    public notification(String dates, String latitudes, String longitudes, String mImages, String times){
        date = dates;
        latitude = latitudes;
        longitude = longitudes;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
