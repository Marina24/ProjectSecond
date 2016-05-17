package com.example.user.projectsecond.model;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

import com.example.user.projectsecond.R;
import com.example.user.projectsecond.ui.RecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

public class Book {

     private String mTitle;
    private int mImageUrl;

    public static String[] bookNameArray = {"Нежные листья, ядовитые корни", "Сойка - пересмешница", "Перекресток миров: начало",
            "50 оттенков свободы", "Код да Винчи", "Ангелы и демоны", "Инферно"};
    public static int[] iconNameArray = {R.drawable.ic_book_one, R.drawable.ic_book_two, R.drawable.ic_book_three,
            R.drawable.ic_book_four, R.drawable.ic_book_five, R.drawable.ic_book_six, R.drawable.ic_book_seven};

    public static ArrayList<Book> booksList() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < bookNameArray.length; i++) {
            Book book = new Book();
            book.setTitle(bookNameArray[i]);
            book.setImageUrl(iconNameArray[i]);
            books.add(book);
        }
        return books;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(int mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
