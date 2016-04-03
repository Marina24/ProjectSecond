package com.example.user.projectsecond.ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.user.projectsecond.R;
import com.example.user.projectsecond.model.ChildData;
import com.example.user.projectsecond.model.GroupData;

import java.util.ArrayList;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private ArrayList<GroupData> mGroups;
    private Context mContext;

    public ExpandableListAdapter (Context context,ArrayList<GroupData> groups){
        mContext = context;
        mGroups = groups;
    }

    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        if(mGroups.get(groupPosition).getChildren() != null)
            return mGroups.get(groupPosition).getChildren().size();
        else
            return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroups.get(groupPosition).getChildren().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {

        View cv = null;
        final GroupData group = (GroupData) getGroup(groupPosition);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            cv = (View)inflater.inflate(R.layout.group_view, parent, false);
        }
        else
        {
            cv = (View) convertView;
        }

        //Get a reference to the group_item elements and set their values
        TextView txtId = (TextView) cv.findViewById(R.id.textGroup);

        if (group != null) {

            txtId.setText(Integer.toString(group.getGroupId()));
            txtId.setText(group.getGroupTitle());
        }

        return cv;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {

        //Get the child object at the specific groupPostion & childPosition
        final ChildData child = (ChildData) getChild(groupPosition,childPosition);

        //Get the reference to the LayoutInflator to inflate the Child item layout
        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_view, parent, false);
        }


        //Get a reference to the child_item elements and set their values
        TextView txtId = (TextView) convertView.findViewById(R.id.textChild);

        if (child != null) {

            int childId = child.getchildId();
            txtId.setText(Integer.toString(childId));

            String childName = child.getchildName();
            txtId.setText(childName);
        }

        return convertView;

    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
