package com.example.user.projectsecond.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.user.projectsecond.R;
import com.example.user.projectsecond.ui.adapter.GridAdapter;


public class GridViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_grid_view);

        GridView gridView = (GridView) findViewById(R.id.gridview);

        gridView.setAdapter(new GridAdapter(this, getResources().getStringArray(R.array.genres_movies)));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,
                        "Press " + getResources().getStringArray(R.array.genres_movies)[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
