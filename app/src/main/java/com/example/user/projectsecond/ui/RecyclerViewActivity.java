package com.example.user.projectsecond.ui;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.user.projectsecond.R;
import com.example.user.projectsecond.model.Book;
import com.example.user.projectsecond.ui.adapter.RecyclerViewAdapter;
import com.example.user.projectsecond.util.Utilities;

import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    private Context mContext;
    private RelativeLayout mRelativeLayout;
    private Button mButtonAdd;
    private EditText mEditSearch;
    private Random mRandom = new Random();
    private RecyclerView mRecyclerView;
    private DatabaseHelper mDatabaseHelper;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private RecyclerViewAdapter mAdapter;
    private List<Book> mDataBooks;
    private Menu mMenu;
    private boolean mIsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        // Get the application context
        mContext = getApplicationContext();

        mIsListView = true;

        //1. Get references
        mButtonAdd = (Button) findViewById(R.id.btn_add);
        mEditSearch = (EditText) findViewById(R.id.edit_search);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        mDatabaseHelper = new DatabaseHelper(RecyclerViewActivity.this);
        // 2. Get all books from database
        mDataBooks = mDatabaseHelper.getAllBooks();
        // 3. Set layoutManger
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        // 4. Create an adapter
        mAdapter = new RecyclerViewAdapter(mContext, mDataBooks);
        // 5. Set adapter
        mRecyclerView.setAdapter(mAdapter);

        searchBook();
        addBook();
    }

    // method search book in data
    public void searchBook() {
        mEditSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String enteredNameBook = s.toString().toLowerCase();
                final List<Book> filteredBooksList = Utilities.filter(mDataBooks, enteredNameBook);
                mAdapter.setUpDateRecyclerViewData(filteredBooksList);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    public void addBook() {
        // Set a click listener for add item button
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Specify the position
                int position = 0;
                Book book = new Book();
                String itemLabel = "Книга " + mRandom.nextInt(100);

                book.setTitle(itemLabel);
                book.setImageUrl(BitmapFactory.decodeResource(getResources(), R.drawable.ic_book_all));

                // Add an item to books list and database
                mDatabaseHelper.createBook(book);
                mDataBooks.add(position, book);

                // Notify the adapter that an item inserted
                mAdapter.notifyItemInserted(position);

                // Scroll to newly added item position
                mRecyclerView.scrollToPosition(position);

                // Update adapter
                mAdapter.setUpDateRecyclerViewData(mDataBooks);

                // Show the added item label
                Toast.makeText(mContext, "Added : " + itemLabel, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_grid_view, menu);
        this.mMenu = menu;
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

    //View changed
    private void toggle() {
        MenuItem item = mMenu.findItem(R.id.action_toggle);
        if (mIsListView) {
            mStaggeredLayoutManager.setSpanCount(2);
            item.setIcon(R.drawable.ic_action_list);
            item.setTitle("Show as list");
            mIsListView = false;
        } else {
            mStaggeredLayoutManager.setSpanCount(1);
            item.setIcon(R.drawable.ic_action_grid);
            item.setTitle("Show as grid");
            mIsListView = true;
        }
    }
}
