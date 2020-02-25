package com.example.compuworld.learnforkids;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;



import java.util.ArrayList;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;






import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.example.compuworld.learnforkids.data.PetContract.PetEntry;


@SuppressWarnings("ALL")
public class QuestionAcvtivity extends program implements
    LoaderManager.LoaderCallbacks<Cursor> {
        private static final int PET_LOADER = 0;
    private InterstitialAd mInterstitialAd;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (Build.VERSION.SDK_INT < 16) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
            setContentView(R.layout.activity_question_acvtivity);

            MobileAds.initialize(this, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                }
            });
            // for intersitial incertisment
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-8871183720829585/2882287827");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    // Load the next interstitial.
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }
            });
            getLoaderManager().initLoader(PET_LOADER, null, this);
            Button groupa =findViewById(R.id.A);
            TextView groupb =(TextView)findViewById(R.id.B);
            TextView groupc =(TextView)findViewById(R.id.C);
            TextView groupd=(TextView)findViewById(R.id.D);
            TextView groupe=(TextView)findViewById(R.id.E);
            TextView groupf=(TextView)findViewById(R.id.F);
            TextView groupg=(TextView)findViewById(R.id.G);
            TextView grouph=(TextView)findViewById(R.id.H);
            TextView groupi=(TextView)findViewById(R.id.I);
            TextView groupj=(TextView)findViewById(R.id.J);


            mInterstitialAd.setAdListener(new AdListener() {
            });
   if(score>=20){

    groupa.setBackgroundColor(Color.parseColor("#FFE082"));
    groupa.setTextColor(Color.parseColor("#000000"));
}
            groupa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent questionintent = new Intent(QuestionAcvtivity.this, GroupAActivity.class);

                    startActivity(questionintent);
                    finish();
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                    }

                }
            });
//
//
            if(score>=40){
                groupb.setBackgroundColor(Color.parseColor("#FFE082"));
                groupb.setTextColor(Color.parseColor("#000000"));
            }

                groupb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (score >= 20) {
                            Intent questionintent = new Intent(QuestionAcvtivity.this, GroupBActivity.class);
                            startActivity(questionintent);
                            finish();
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                            } else {
                            }


                        }
                    }
                });
            if(score<20){
                groupb.setOnClickListener(new View.OnClickListener() {
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
                        showUnsavedChangesDialog(discardButtonClickListener);
                    }
                });

            }
            //
            if(score>=60){
                groupc.setBackgroundColor(Color.parseColor("#FFE082"));
                groupc.setTextColor(Color.parseColor("#000000"));
            }

            groupc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (score >= 40) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                        }

                        Intent questionintent = new Intent(QuestionAcvtivity.this, GroupCActivity.class);
                        startActivity(questionintent);
                        finish();
                    }
                }
            });
            if(score<40){
                groupc.setOnClickListener(new View.OnClickListener() {
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
                        showUnsavedChangesDialog(discardButtonClickListener);
                    }
                });

            }

//
            //
            if(score>=80){
                groupd.setBackgroundColor(Color.parseColor("#FFE082"));
                groupd.setTextColor(Color.parseColor("#000000"));
            }

            groupd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (score >= 60) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                        }

                        Intent questionintent = new Intent(QuestionAcvtivity.this, GroupDActivity.class);
                        startActivity(questionintent);
                        finish();
                    }
                }
            });
            if(score<60){
                groupd.setOnClickListener(new View.OnClickListener() {
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
                        showUnsavedChangesDialog(discardButtonClickListener);
                    }
                });

            }

//
            //
            if(score>=100){
                groupe.setBackgroundColor(Color.parseColor("#FFE082"));
                groupe.setTextColor(Color.parseColor("#000000"));
            }

            groupe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (score >= 80) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                        }

                        Intent questionintent = new Intent(QuestionAcvtivity.this, GroupEActivity.class);
                        startActivity(questionintent);
                        finish();
                    }
                }
            });
            if(score<80){
                groupe.setOnClickListener(new View.OnClickListener() {
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
                        showUnsavedChangesDialog(discardButtonClickListener);
                    }
                });

            }
            //
            ///////
            if(score>=120){
                groupf.setBackgroundColor(Color.parseColor("#FFE082"));
                groupf.setTextColor(Color.parseColor("#000000"));
            }

            groupf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (score >= 100) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                        }

                        Intent questionintent = new Intent(QuestionAcvtivity.this, GroupFActivity.class);
                        startActivity(questionintent);
                        finish();
                    }
                }
            });
            if(score<100){
                groupf.setOnClickListener(new View.OnClickListener() {
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
                        showUnsavedChangesDialog(discardButtonClickListener);
                    }
                });

            }
//
//
            if(score>=140){
                groupg.setBackgroundColor(Color.parseColor("#FFE082"));
                groupg.setTextColor(Color.parseColor("#000000"));
            }

            groupg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (score >= 120) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                        }

                        Intent questionintent = new Intent(QuestionAcvtivity.this, GroupGActivity.class);
                        startActivity(questionintent);
                        finish();
                    }
                }
            });
            if(score<120){
                groupg.setOnClickListener(new View.OnClickListener() {
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
                        showUnsavedChangesDialog(discardButtonClickListener);
                    }
                });

            }
            //
            if(score>=160){
                grouph.setBackgroundColor(Color.parseColor("#FFE082"));
                grouph.setTextColor(Color.parseColor("#000000"));
            }

            grouph.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (score >= 40) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                        }

                        Intent questionintent = new Intent(QuestionAcvtivity.this, GroupHActivity.class);
                        startActivity(questionintent);
                        finish();
                    }
                }
            });
            if(score<140){
                grouph.setOnClickListener(new View.OnClickListener() {
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
                        showUnsavedChangesDialog(discardButtonClickListener);
                    }
                });

            }

//
            //
            if(score>=180){
                groupi.setBackgroundColor(Color.parseColor("#FFE082"));
                groupi.setTextColor(Color.parseColor("#000000"));
            }

            groupi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (score >= 60) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                        }

                        Intent questionintent = new Intent(QuestionAcvtivity.this, GroupIActivity.class);
                        startActivity(questionintent);
                        finish();
                    }
                }
            });
            if(score<160){
                groupi.setOnClickListener(new View.OnClickListener() {
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
                        showUnsavedChangesDialog(discardButtonClickListener);
                    }
                });

            }

//
            //
            if(score>=200){
                groupj.setBackgroundColor(Color.parseColor("#FFE082"));
                groupj.setTextColor(Color.parseColor("#000000"));
            }

            groupj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (score >= 180) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                        }

                        Intent questionintent = new Intent(QuestionAcvtivity.this, GroupJActivity.class);
                        startActivity(questionintent);
                        finish();
                    }
                }
            });
            if(score<180){
                groupj.setOnClickListener(new View.OnClickListener() {
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
                        showUnsavedChangesDialog(discardButtonClickListener);
                    }
                });

            }
            //








            TextView backmain =(TextView) findViewById(R.id.backmain);
            backmain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    finish();
                }
            });


                }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

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

        int scoreIndex =cursor.getColumnIndex(PetEntry.PET_COLUMN_SCORE);
        int nameIndex = cursor.getColumnIndex(PetEntry.PET_COLUMN_NAME);
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

