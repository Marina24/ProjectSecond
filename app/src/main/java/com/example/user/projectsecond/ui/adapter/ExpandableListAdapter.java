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
import java.util.HashMap;

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


    public static class ViewHolder{
        private HashMap<Integer, View> storedViews = new HashMap<>();

        public ViewHolder(){}

        public ViewHolder addView(View view){
            int id = view.getId();
            storedViews.put(id, view);
            return this;
        }
        public View getView(int id){
            return storedViews.get(id);
        }
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {

        View row = null;
        ViewHolder holder;
        final GroupData group = (GroupData) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = (View)inflater.inflate(R.layout.group_view, parent, false);
            TextView txtId = (TextView) row.findViewById(R.id.textGroup);
            holder = new ViewHolder();
            holder.addView(txtId);
            row.setTag(holder);
        } else {
            row = (View) convertView;
            holder = (ViewHolder) row.getTag();
        }

        if (group != null) {
            View myView = holder.getView(R.id.textGroup);
            TextView textView = (TextView) myView;
            textView.setText(group.getGroupTitle());
        }
        return row;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {

        //Get the child object at the specific groupPostion & childPosition
        final ChildData child = (ChildData) getChild(groupPosition,childPosition);

        ViewHolder holder;

        if (convertView == null) {
            final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_view, parent, false);
            TextView txtId = (TextView) convertView.findViewById(R.id.textChild);
            holder = new ViewHolder();
            holder.addView(txtId);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (child != null) {

            View myView = holder.getView(R.id.textChild);
            TextView textView = (TextView) myView;
            textView.setText(child.getchildName());
        }

        return convertView;

    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
