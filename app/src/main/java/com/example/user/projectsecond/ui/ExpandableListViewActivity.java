package com.example.user.projectsecond.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.user.projectsecond.R;
import com.example.user.projectsecond.model.ChildDataBooks;
import com.example.user.projectsecond.model.GroupDataAuthors;
import com.example.user.projectsecond.ui.adapter.ExpandableListAdapter;

import java.util.ArrayList;


public class ExpandableListViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_expandable_list_view);

        final ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable_list);

        final ArrayList<GroupDataAuthors> myGroups = createGroupData();

        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(getApplicationContext(), myGroups);

        expandableListView.setAdapter(expListAdapter);


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            int previousItem = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousItem)
                    //if a different Group is expanded, collapse the previous Expanded Group
                    expandableListView.collapseGroup(previousItem);
                previousItem = groupPosition;
            }
        });

        //To set on Click listener for the Group
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Toast.makeText(getApplicationContext(), "Author " + myGroups.get(groupPosition).getGroupTitle()
                        + " is Clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        //To set on Click listener for the Children
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "Author " + myGroups.get(groupPosition).getGroupTitle()
                        + " , book " + myGroups.get(groupPosition).getChildren().get(childPosition).getChildName()
                        + " is Clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }


    private ArrayList<GroupDataAuthors> createGroupData() {
        ArrayList<GroupDataAuthors> GroupList = new ArrayList<GroupDataAuthors>();

        // get our data from string-array resource
        String[] mGroups = getResources().getStringArray(R.array.group_authors);


        for (int i = 0; i < mGroups.length; i++) {
            //Create a new Group object
            GroupDataAuthors aGroup = new GroupDataAuthors();
            aGroup.setGroupId(i);
            aGroup.setGroupTitle(mGroups[i]);

            //get each group children from string-array
            String[] mChildren = null;
            switch (i) {
                case 0:
                    mChildren = getResources().getStringArray(R.array.array_books_brauns);
                    break;
                case 1:
                    mChildren = getResources().getStringArray(R.array.array_books_agata_christie);
                    break;
                case 2:
                    mChildren = getResources().getStringArray(R.array.array_books_lev_tolstoy);
                    break;
                case 3:
                    mChildren = getResources().getStringArray(R.array.array_books_stephen_king);
                    break;

                default:
                    mChildren = new String[]{"Child1", "Child2", "Child3"};
            }

            //Create an ArrayList of children
            ArrayList<ChildDataBooks> ChildList = new ArrayList<ChildDataBooks>();

            for (int j = 0; j < mChildren.length; j++) {
                //Create a new child object
                ChildDataBooks aChild = new ChildDataBooks();

                //fill the child object
                aChild.setChildId(j);
                aChild.setChildName(mChildren[j]);

                //add each child object to the arrayList of Children
                ChildList.add(aChild);
            }

            //add the ArrayList of children to the current GroupList object
            aGroup.setChildren(ChildList);

            //add the current group object to the ArrayList of GroupList objects
            GroupList.add(aGroup);

        }

        return GroupList;
    }
}
