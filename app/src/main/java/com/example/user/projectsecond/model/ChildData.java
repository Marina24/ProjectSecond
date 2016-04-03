package com.example.user.projectsecond.model;


public class ChildData {

    private int childId;
    private String childName;

    public ChildData(){}

    public ChildData(int childId, String childName)
    {
        this.childId = childId;
        this.childName = childName;
    }

    public int getchildId()
    {
        return this.childId;
    }

    public void setchildId(int childId)
    {
        this.childId = childId;
    }

    public String getchildName()
    {
        return this.childName;
    }

    public void setchildName(String childName)
    {
        this.childName = childName;
    }


}

