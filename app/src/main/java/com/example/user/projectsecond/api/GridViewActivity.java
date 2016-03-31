package com.example.user.projectsecond.api;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.user.projectsecond.R;
import com.example.user.projectsecond.api.adapter.GridAdapter;


public class GridViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_grid_view);

        GridView gridView = (GridView) findViewById(R.id.gridview);

        gridView.setAdapter(new GridAdapter(this, getResources().getStringArray(R.array.genres_movies)));
    }
}
