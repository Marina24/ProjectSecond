package com.example.user.projectsecond.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.user.projectsecond.model.Book;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Utilities {

    // convert from Bitmap to byte array
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    // convert from byte array to Bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    // method to search book that match the input data
    public static List<Book> filter(List<Book> books, String query) {
        query = query.toLowerCase();

        final List<Book> filteredBooksList = new ArrayList<>();
        for (Book book : books) {
            final String text = book.getTitle().toLowerCase();
            if (text.contains(query)) {
                filteredBooksList.add(book);
            }
        }
        return filteredBooksList;
    }
}
