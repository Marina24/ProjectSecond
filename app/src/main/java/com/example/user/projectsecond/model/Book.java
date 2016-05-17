package com.example.user.projectsecond.model;


import android.graphics.Bitmap;


public class Book {

    private String mTitle;
    private Bitmap mImageUrl;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Bitmap getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(Bitmap mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
