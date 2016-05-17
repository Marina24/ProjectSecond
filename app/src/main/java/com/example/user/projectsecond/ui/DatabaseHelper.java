package com.example.user.projectsecond.ui;


import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import com.example.user.projectsecond.Const;
import com.example.user.projectsecond.R;
import com.example.user.projectsecond.model.Book;
import com.example.user.projectsecond.util.Utilities;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final String TAG = this.getClass().getSimpleName();
    private final Context fContext;

    public static interface Tables {
        String CATEGORIES = "books";
    }

    private static final String CREATE_TABLE_CATEGORIES = new StringBuilder().append("CREATE TABLE ")
            .append(Tables.CATEGORIES).append("(")
            .append(DatabaseContract.Category._ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT,")
            .append(DatabaseContract.Category.NAME).append(" TEXT, ")
            .append(DatabaseContract.Category.IMAGE).append(" BLOB ")
            .append(")").toString();


    public DatabaseHelper(Context context) {
        super(context, Tables.CATEGORIES, null, DatabaseContract.Category.DATABASE_VERSION);
        fContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v(TAG, "CREATE TABLE CALL:" + CREATE_TABLE_CATEGORIES);
        db.execSQL(CREATE_TABLE_CATEGORIES);

        ContentValues values = new ContentValues();

        for (int i = 0; i < Const.bookNameArray.length; i++) {
            values.put(DatabaseContract.Category.NAME, Const.bookNameArray[i]);
            Resources res = fContext.getResources();
            values.put(DatabaseContract.Category.IMAGE, Utilities.getBytes(BitmapFactory.decodeResource(
                    res, Const.iconNameArray[i])));
            db.insert(Tables.CATEGORIES, null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + Tables.CATEGORIES);
        onCreate(db);
    }

    //Method to create book
    public long createBook(Book book) {
        long c;

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Category.NAME, book.getTitle());
        values.put(DatabaseContract.Category.IMAGE, Utilities.getBytes(book.getImageUrl()));

        c = database.insert(Tables.CATEGORIES, null, values);
        database.close();
        return c;
    }

    public ArrayList<Book> getAllBooks() {
        String query = "SELECT * FROM " + Tables.CATEGORIES;
        ArrayList<Book> books = new ArrayList<Book>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndex(DatabaseContract.Category.NAME));
                Bitmap image = Utilities.getImage(cursor.getBlob(cursor.getColumnIndex(DatabaseContract.Category.IMAGE)));

                Book book = new Book();
                book.setTitle(title);
                book.setImageUrl(image);

                Log.v("DBHelper: ", "Title: " + title);
                Log.v("DBHelper: ", "Image: " + image.toString());

                books.add(book);
            }
        }
        return books;
    }

    public Book getBookByTitle(String title) {
        String query = "SELECT * FROM " + Tables.CATEGORIES + " where " + DatabaseContract.Category.NAME + " LIKE '%" + title + "%'";
        Book book = new Book();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();
            String titl = cursor.getString(cursor.getColumnIndex(DatabaseContract.Category.NAME));
            Bitmap image = Utilities.getImage(cursor.getBlob(cursor.getColumnIndex(DatabaseContract.Category.IMAGE)));

            book.setTitle(titl);
            book.setImageUrl(image);

            Log.v("DBHelper: ", "Title: " + title);
            Log.v("DBHelper: ", "Image: " + image.toString());
        }
        return book;
    }
}
