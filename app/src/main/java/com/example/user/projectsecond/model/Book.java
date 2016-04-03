package com.example.user.projectsecond.model;


import com.example.user.projectsecond.R;

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
            book.setmTitle(bookNameArray[i]);
            book.setmImageUrl(iconNameArray[i]);
            books.add(book);
        }
        return books;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(int mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
