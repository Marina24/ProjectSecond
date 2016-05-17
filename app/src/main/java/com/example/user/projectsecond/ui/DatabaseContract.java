package com.example.user.projectsecond.ui;

import android.provider.BaseColumns;


public final class DatabaseContract {

    interface CategoryColumns {
        String NAME = "name";
        String IMAGE = "image";
    }

    private DatabaseContract() {
    }

    public static class Category implements BaseColumns, CategoryColumns {

        public static final int DATABASE_VERSION = 1;

        public interface Query {
            String SORT = Category.NAME + " ASC";
            String[] PROJECTION = {
                    Category._ID,
                    Category.NAME,
                    Category.IMAGE
            };
            int _ID = 0;
            int NAME = 1;
            int IMAGE = 2;
        }
    }
}
