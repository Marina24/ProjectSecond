package com.example.user.projectsecond.model;

import java.util.ArrayList;


public class GroupDataAuthors {
    private int mGroupId;
    private String mGroupTitle;
    private ArrayList<ChildDataBooks> mChildren;


    public GroupDataAuthors() {
    }

    public GroupDataAuthors(int groupId, String groupTitle, ArrayList<ChildDataBooks> Children) {
        this.mGroupId = groupId;
        this.mGroupTitle = groupTitle;
        this.mChildren = Children;

    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(int groupId) {
        this.mGroupId = groupId;
    }

    public String getGroupTitle() {
        return this.mGroupTitle;
    }


    public void setGroupTitle(String groupTitle) {
        this.mGroupTitle = groupTitle;
    }

    public ArrayList<ChildDataBooks> getChildren() {
        return this.mChildren;
    }

    public void setChildren(ArrayList<ChildDataBooks> Children) {
        this.mChildren = Children;
    }
}
