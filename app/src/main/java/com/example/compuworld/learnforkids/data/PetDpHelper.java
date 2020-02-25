package com.example.compuworld.learnforkids.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.compuworld.learnforkids.data.PetContract.PetEntry;
public class PetDpHelper extends SQLiteOpenHelper {
    public static  int DATA_BASE_VERSION=1;
    public static final String DATA_BASE_NAME="shelter.dp";
    public  PetDpHelper (Context context){
        super(context,DATA_BASE_NAME,null,DATA_BASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + "("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PetEntry.PET_COLUMN_NAME + " INTEGER,"
                + PetEntry.PET_COLUMN_VA + " INTEGER,"
                + PetEntry.PET_COLUMN_VB + " INTEGER,"

                + PetEntry.PET_COLUMN_SCORE + " INTEGER DEFAULT 0 );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELTE =" DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;
     DATA_BASE_VERSION=2;
     db.execSQL(SQL_DELTE);
     onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
