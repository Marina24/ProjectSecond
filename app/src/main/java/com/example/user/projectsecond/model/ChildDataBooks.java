package com.example.user.projectsecond.model;


public class ChildDataBooks {

    private int mChildId;
    private String mChildName;

    public ChildDataBooks() {
    }

    public ChildDataBooks(int childId, String childName) {
        this.mChildId = childId;
        this.mChildName = childName;
    }

    public int getChildId() {
        return this.mChildId;
    }

    public void setChildId(int childId) {
        this.mChildId = childId;
    }

    public String getChildName() {
        return this.mChildName;
    }

    public void setChildName(String childName) {
        this.mChildName = childName;
    }


}

