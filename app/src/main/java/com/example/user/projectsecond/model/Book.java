package com.example.user.projectsecond.model;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

import com.example.user.projectsecond.Const;
import com.example.user.projectsecond.R;
import com.example.user.projectsecond.ui.RecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int mCode;
    private String mTitle;
    private Bitmap mImageUrl;

    public int getCode() {
        return mCode;
    }

    public void setCode(int mCode) {
        this.mCode = mCode;
    }

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
