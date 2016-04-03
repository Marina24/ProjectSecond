package com.example.user.projectsecond.ui;



import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.user.projectsecond.R;
import com.example.user.projectsecond.model.Book;
import com.example.user.projectsecond.ui.adapter.RecyclerViewAdapter;

import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    private Context mContext;
    LinearLayout mLinearLayout;
    private Button mButtonAdd;
    private Random mRandom = new Random();
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private RecyclerViewAdapter mAdapter;
    final List<Book> books = Book.booksList();
    private Menu menu;
    private boolean isListView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);

        // Get the application context
        mContext = getApplicationContext();

        isListView = true;

        //1. Get references on recyclerView
        mButtonAdd = (Button) findViewById(R.id.btn_add);
        mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        // 2. Set layoutManger
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

        // 3. Create an adapter
        mAdapter = new RecyclerViewAdapter(mContext, books);

        // 4. Set adapter
        mRecyclerView.setAdapter(mAdapter);

        // Set a click listener for add item button
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Specify the position
                int position = 0;
                Book book = new Book();
                String itemLabel = "Книга " + mRandom.nextInt(100);

                book.setmTitle(itemLabel);
                book.setmImageUrl(R.drawable.ic_book_all);

                // Add an item to animals list
                books.add(position, book);

                // Notify the adapter that an item inserted
                mAdapter.notifyItemInserted(position);


                // Scroll to newly added item position
                mRecyclerView.scrollToPosition(position);

                // Show the added item label
                Toast.makeText(mContext, "Added : " + itemLabel, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_grid_view, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_toggle) {
            toggle();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggle() {
        MenuItem item = menu.findItem(R.id.action_toggle);
        if (isListView) {
            mStaggeredLayoutManager.setSpanCount(2);
            item.setIcon(R.drawable.ic_action_list);
            item.setTitle("Show as list");
            isListView = false;
        } else {
            mStaggeredLayoutManager.setSpanCount(1);
            item.setIcon(R.drawable.ic_action_grid);
            item.setTitle("Show as grid");
            isListView = true;
        }
    }
}
