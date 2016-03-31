package com.example.user.projectsecond.api;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.user.projectsecond.api.adapter.MyAdapter;
import com.example.user.projectsecond.R;

public class ListViewActivity extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_list_view);

        // Использование собственного шаблона
        setListAdapter(new MyAdapter(this, getResources().getStringArray(R.array.bookName),
                getResources().getStringArray(R.array.nameAuthor)));
    }
}