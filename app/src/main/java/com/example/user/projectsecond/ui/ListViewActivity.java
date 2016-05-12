package com.example.user.projectsecond.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.projectsecond.ui.adapter.ListViewAdapter;
import com.example.user.projectsecond.R;

public class ListViewActivity extends ListActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_list_view);


        // using own template
        setListAdapter(new ListViewAdapter(this, getResources().getStringArray(R.array.bookName),
                getResources().getStringArray(R.array.nameAuthor)));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(getApplicationContext(),
                "Press: " + getResources().getStringArray(R.array.nameAuthor)[position],
                Toast.LENGTH_SHORT).show();
    }
}