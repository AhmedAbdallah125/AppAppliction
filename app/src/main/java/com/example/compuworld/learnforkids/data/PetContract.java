package com.example.compuworld.learnforkids.data;

import android.net.Uri;
import android.provider.BaseColumns;

public final class PetContract {
    private PetContract() {}



    public static final class PetEntry implements BaseColumns {
        public final static String TABLE_NAME = "pets";
        public final static String _ID = BaseColumns._ID;
        public final static String PET_COLUMN_NAME = "name"  ;
        public final static String PET_COLUMN_SCORE ="score";

        public final static String PET_COLUMN_VA ="va";
        public final static String PET_COLUMN_VB ="vb";

        public static final String CONTENT_AUTHORITY = "com.example.compuworld.learnforkids";
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
        public static final String PATH_PETS = "pets";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);
    }



}


