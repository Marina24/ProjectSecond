package com.example.user.projectsecond.model;

import java.util.ArrayList;


public class GroupData {
    private int groupId;
    private String groupTitle;
    private ArrayList<ChildData> Children;


    public GroupData(){}

    public GroupData(int groupId, String groupTitle,ArrayList<ChildData> Children)
    {
        this.groupId = groupId;
        this.groupTitle = groupTitle;
        this.Children= Children;

    }

    public int getGroupId()
    {
        return this.groupId;
    }

    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }

    public String getGroupTitle()
    {
        return this.groupTitle;
    }


    public void setGroupTitle(String groupTitle)
    {
        this.groupTitle = groupTitle;
    }

    public ArrayList<ChildData> getChildren()
    {
        return this.Children;
    }

    public void setChildren(ArrayList<ChildData> Children)
    {
        this.Children = Children;
    }
}
