package com.example.compuworld.learnforkids;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;



import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
import com.example.compuworld.learnforkids.data.PetContract.PetEntry;
import com.example.compuworld.learnforkids.data.PetProvider;
@SuppressWarnings("deprecation")
public class MainActivity extends program implements
        LoaderManager.LoaderCallbacks<Cursor> {
    private static final int PET_LOADER = 0;

//    private AdView mAdView;
//
//
//    AdSize adSize = new AdSize(300, 50);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);

//
//        AdView adView = new AdView(this);
//        adView.setAdSize(AdSize.SMART_BANNER);
//
//
//        MobileAds.initialize(this, "ca-app-pub-8871183720829585~8202918105");
//        adView = new AdView(this);
//
//        adView.setAdSize(AdSize.BANNER);
//        adView.setAdUnitId("ca-app-pub-8871183720829585/8868707485");
//// TODO: Add adView to your view hierarchy.
//
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//
//        mAdView.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                // Code to be executed when an ad finishes loading.
//            }
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//                // Code to be executed when an ad request fails.
//            }
//
//            @Override
//            public void onAdOpened() {
//                // Code to be executed when an ad opens an overlay that
//                // covers the screen.
//            }
//
//            @Override
//            public void onAdLeftApplication() {
//                // Code to be executed when the user has left the app.
//            }
//
//            @Override
//            public void onAdClosed() {
//                // Code to be executed when when the user is about to return
//                // to the app after tapping on an ad.
//            }
//
//        });


        Button star = (Button) findViewById(R.id.star);
        Button clos = (Button) findViewById(R.id.end);
        final String [] pro={
                PetEntry.PET_COLUMN_NAME,
                PetEntry.PET_COLUMN_SCORE


        };

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor =getContentResolver().query(PetEntry.CONTENT_URI,pro,
                        null,null,null);
                if(cursor.getCount()==0){
                    inser();
                    Intent questionintent = new Intent(MainActivity.this, QuestionAcvtivity.class);


                    startActivity(questionintent);

                    Toast.makeText(getBaseContext(),"good luck",Toast.LENGTH_SHORT).show();

                }else{
                    Intent questionintent = new Intent(MainActivity.this, QuestionAcvtivity.class);

                    startActivity(questionintent);

                }
            }
        });
        clos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        getLoaderManager().initLoader(PET_LOADER, null, this);

    }

    private void inser() {


        // Create a ContentValues object where column names are the keys,
        // and Toto's pet attributes are the values.
        ContentValues values = new ContentValues();
        values.put(PetEntry.PET_COLUMN_NAME, 1);
        values.put(PetEntry.PET_COLUMN_SCORE, score);
        values.put(PetEntry.PET_COLUMN_VA,0);
        values.put(PetEntry.PET_COLUMN_VB,0);


        // Insert a new row for Toto in the database, returning the ID of that new row.
        // The first argument for db.insert() is the pets table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for Toto.
        Uri newUri = getContentResolver().insert(PetEntry.CONTENT_URI, values);
        if (newUri == null) {

            // If the new content URI is null, then there was an error with insertion.
            Toast.makeText(this, "failed",
                    Toast.LENGTH_SHORT).show();
        } else {

            // Otherwise, the insertion was successful and we can display a toast.
            Toast.makeText(this, "succd",
                    Toast.LENGTH_SHORT).show();
        }


    }

//

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(MainActivity.this,Alarm_trys.class);
        int time =2;
        PendingIntent pendingIntent =PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
        AlarmManager alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+time*1000,pendingIntent);
        super.onDestroy();

    }


    //    @Override
//    protected void onPause() {
//        super.onPause();
//        Intent intent = new Intent(MainActivity.this,Alarm_trys.class);
//        int time =3;
//        PendingIntent pendingIntent =PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
//        AlarmManager alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+time*1000,pendingIntent);
//    }
    @Override
    protected void onStart() {
        super.onStart();
        getBaseContext().getContentResolver().notifyChange(PetEntry.CONTENT_URI, null);

    }
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Define a projection that specifies the columns from the table we care about.
        String[] projection = {
                PetEntry.PET_COLUMN_NAME,
                PetEntry.PET_COLUMN_SCORE,
                PetEntry.PET_COLUMN_VA,
                PetEntry.PET_COLUMN_VB
        };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                PetEntry.CONTENT_URI,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        int nameIndex = cursor.getColumnIndex(PetEntry.PET_COLUMN_NAME);

        int scoreIndex =cursor.getColumnIndex(PetEntry.PET_COLUMN_SCORE);
        int vaIndex = cursor.getColumnIndex(PetEntry.PET_COLUMN_VA);
        int vbIndex = cursor.getColumnIndex(PetEntry.PET_COLUMN_VB);

        while (cursor.moveToNext()) {
            tr =cursor.getInt(nameIndex);
            score = cursor.getInt(scoreIndex);
            va = cursor.getInt(vaIndex);
            vb =cursor.getInt(vbIndex);


            // you must make some space

        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}

