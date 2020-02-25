package com.example.compuworld.learnforkids;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compuworld.learnforkids.data.PetContract.PetEntry;
import com.example.compuworld.learnforkids.data.PetProvider;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;

import com.example.compuworld.learnforkids.data.PetContract.PetEntry;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
@SuppressWarnings("ALL")

public class Qc7Activity extends program implements
        LoaderManager.LoaderCallbacks<Cursor>, RewardedVideoAdListener {
    private static final int PET_LOADER = 0;

    TextView first;
    TextView second;
    TextView third;
    TextView question;
    TextView solText;
    TextView mtrys;
    private RewardedVideoAd mRewardedVideoAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qc7);
        MobileAds.initialize(this, "ca-app-pub-8871183720829585~8202918105");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        // for rewarding video
        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",new AdRequest.Builder().build());

        // for banner advertisment
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

// TODO: Add adView to your view hierarchy.
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        TextView backmain = (TextView) findViewById(R.id.back);


        question = (TextView) findViewById(R.id.question);
        first = (TextView) findViewById(R.id.first);
        second = (TextView) findViewById(R.id.second);
        third = (TextView) findViewById(R.id.third);
        solText = findViewById(R.id.solv);
        mtrys =(TextView) findViewById(R.id.trys);

        // Kick off the loader
        backmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                startActivity(new Intent(Qc7Activity.this,GroupCActivity.class));
                finish();

            }
        });

        getLoaderManager().initLoader(PET_LOADER, null, this);

    }
    @Override
    protected void onResume() {
//        mRewardedVideoAd.resume(this);

        super.onResume();
        getBaseContext().getContentResolver().notifyChange(PetEntry.CONTENT_URI, null);

    }
    @Override
    public void onPause() {
//        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
//        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

        startActivity(new Intent(Qc7Activity.this,GroupCActivity.class));
        finish();
    }

    @Override
    protected void onStart() {
        getBaseContext().getContentResolver().notifyChange(PetEntry.CONTENT_URI, null);
        // for rewarding video
        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd   = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",new AdRequest.Builder().build());
        super.onStart();
        question.setText("السوره التى لا تبدأ بالبسمله ....");
        first.setText("التوبه");
        second.setText("الاخلاص");
        third.setText("المائده");

// rewarding vido
        mtrys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {


                if(mRewardedVideoAd.isLoaded()){

                    mRewardedVideoAd.show();
                }
                else {

                    DialogInterface.OnClickListener discardButtonClickListener =
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // User clicked "Discard" button, close the current activity.
                                }
                            };
                    // Show dialog that there are unsaved changes
                    noHelpedAvailable(discardButtonClickListener);

                }
            }
        });if(tr>0) {
            if(tr>2){
                solText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View e) {
                        tr=tr-2;
                        va=1;
                        vb=1;
                        ContentValues values = new ContentValues();
                        values.put(PetEntry.PET_COLUMN_NAME, tr);
                        values.put(PetEntry.PET_COLUMN_VA, va);
                        values.put(PetEntry.PET_COLUMN_VB, vb);
                        getContentResolver().update(PetEntry.CONTENT_URI, values, null, null);
                        second.setVisibility(View.INVISIBLE);
                        third.setVisibility(View.INVISIBLE);
                    }
                });
            }
            if (score == 46) {
                first.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "اجابه صحيحه" + "\n" + "يمكنك الذهاب للسؤال التالى", Toast.LENGTH_SHORT).show();
                        score++;
                        va=0;
                        vb=0;
                        ContentValues values = new ContentValues();
                        values.put(PetEntry.PET_COLUMN_SCORE, score);
                        values.put(PetEntry.PET_COLUMN_VA, va);
                        values.put(PetEntry.PET_COLUMN_VB, vb);
                        getContentResolver().update(PetEntry.CONTENT_URI, values, null, null);
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());
                        startActivity(new Intent(Qc7Activity.this, Qc8Activity.class));
                        finish();
                    }
                });
                if(va==0) {
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tr = tr - 1;
                            va++;
                            ContentValues values = new ContentValues();
                            values.put(PetEntry.PET_COLUMN_NAME, tr);
                            values.put(PetEntry.PET_COLUMN_VA, va);
                            getContentResolver().update(PetEntry.CONTENT_URI, values, null, null);
                            DialogInterface.OnClickListener discardButtonClickListener =
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            // User clicked "Discard" button, close the current activity.
                                        }
                                    };
                            third.setVisibility(View.INVISIBLE);
                            // Show dialog that there are unsaved changes
                            showWrongAnswer(discardButtonClickListener);
                            onStart();
                        }
                    });
                }
                else{
                    third.setVisibility(View.INVISIBLE);

                }
                if(vb==0){
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tr = tr - 1;
                            vb++;
                            ContentValues values = new ContentValues();
                            values.put(PetEntry.PET_COLUMN_NAME, tr);
                            values.put(PetEntry.PET_COLUMN_VB, vb);

                            getContentResolver().update(PetEntry.CONTENT_URI, values, null, null);
                            DialogInterface.OnClickListener discardButtonClickListener =
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            // User clicked "Discard" button, close the current activity.
                                        }
                                    };


                            second.setVisibility(View.INVISIBLE);
                            // Show dialog that there are unsaved changes
                            showWrongAnswer(discardButtonClickListener);
                            onStart();
                        }
                    });

                }else {

                    second.setVisibility(View.INVISIBLE);
                }

            }
        } else{

            first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View e) {
                    DialogInterface.OnClickListener discardButtonClickListener =
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // User clicked "Discard" button, close the current activity.
                                }
                            };

                    // Show dialog that there are unsaved changes
                    gone(discardButtonClickListener);
                }
            });
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View e) {
                    DialogInterface.OnClickListener discardButtonClickListener =
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // User clicked "Discard" button, close the current activity.
                                }
                            };
                    // Show dialog that there are unsaved changes
                    gone(discardButtonClickListener);
                }
            });
            third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View e) {
                    DialogInterface.OnClickListener discardButtonClickListener =
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // User clicked "Discard" button, close the current activity.
                                }
                            };
                    // Show dialog that there are unsaved changes
                    gone(discardButtonClickListener);
                }
            });
        }
        if(score>46){
            first.setBackgroundColor(Color.parseColor("#FFC107"));
            second.setBackgroundColor(Color.parseColor("#FFECB3"));
            third.setBackgroundColor(Color.parseColor("#FFECB3"));
            solText.setVisibility(View.INVISIBLE);
            solText.setBackgroundColor(Color.parseColor("#000000"));
        }
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
        int scoreIndex =cursor.getColumnIndex(PetEntry.PET_COLUMN_SCORE);
        int nameIndex = cursor.getColumnIndex(PetEntry.PET_COLUMN_NAME);
        int vaIndex = cursor.getColumnIndex(PetEntry.PET_COLUMN_VA);
        int vbIndex = cursor.getColumnIndex(PetEntry.PET_COLUMN_VB);
        while (cursor.moveToNext()) {
            int cureentscore = cursor.getInt(scoreIndex);
            tr =cursor.getInt(nameIndex);
            score = cureentscore;
            mtrys.setText("+" + ""+String.valueOf(tr));

            va = cursor.getInt(vaIndex);
            vb =cursor.getInt(vbIndex);

        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }
    @Override
    public void onRewarded(RewardItem reward) {

        // Reward the user.
        tr++;

        ContentValues values = new ContentValues();
        values.put(PetEntry.PET_COLUMN_NAME, tr);
        getContentResolver().update(PetEntry.CONTENT_URI, values, null, null);
        onStart();
        Toast.makeText(this,"حصلت على محاوله جديده",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        mtrys.setEnabled(true);
    }

    @Override
    public void onRewardedVideoAdOpened() {
    }

    @Override
    public void onRewardedVideoStarted() {
    }

    @Override
    public void onRewardedVideoCompleted() {

    }
}



