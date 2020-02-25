package com.example.compuworld.learnforkids;

import android.app.AlarmManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.compuworld.learnforkids.data.PetDpHelper;
import com.example.compuworld.learnforkids.data.PetContract.PetEntry;
import com.google.android.gms.ads.AdView;

import java.security.acl.Group;

public class GroupAActivity extends program  implements
        LoaderManager.LoaderCallbacks<Cursor> {
    private static final int PET_LOADER = 0;
    TextView mtrys;
    TextView a1;    TextView a2;
    TextView a3;
    TextView a4;
    TextView a5;
    TextView a6;
    TextView displayView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }


        setContentView(R.layout.activity_group_a);

        TextView backmain = (TextView) findViewById(R.id.backmain);
         a1 = (TextView) findViewById(R.id.q1);
         a2 = (TextView) findViewById(R.id.q2);
         a3 = (TextView) findViewById(R.id.q3);
         a4 = (TextView) findViewById(R.id.q4);
         a5 = (TextView) findViewById(R.id.q5);
         a6 = (TextView) findViewById(R.id.q6);
         displayView = (TextView) findViewById(R.id.score);
         mtrys =(TextView) findViewById(R.id.trys);
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        getBaseContext().getContentResolver().notifyChange(P