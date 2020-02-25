package com.example.compuworld.learnforkids;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

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
import java.security.acl.Group; import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compuworld.learnforkids.data.PetContract;
import com.example.compuworld.learnforkids.data.PetDpHelper;

@SuppressWarnings("ALL")

public class GroupEActivity extends program  implements
        LoaderManager.LoaderCallbacks<Cursor>, RewardedVideoAdListener {
    private static final int PET_LOADER = 0;
    RewardedVideoAd mRewardedVideoAd;
    TextView mtrys;
    TextView a1;    TextView a2;
    TextView a3;
    TextView a4;
    TextView a5;
    TextView a6;
    TextView a7;    TextView a16;
    TextView a8;
    TextView a9;
    TextView a10;
    TextView a11; TextView a17;    TextView a20;
    TextView a12;
    TextView a13;TextView a18;TextView a19;
    TextView a14;
    TextView a15;
    TextView displayView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_e);
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
//

        // for banner advertisment
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");


// TODO: Add adView to your view hierarchy.
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        TextView backmain = (TextView) findViewById(R.id.backmain);
        a1 = (TextView) findViewById(R.id.q1);
        a2 = (TextView) findViewById(R.id.q2);
        a3 = (TextView) findViewById(R.id.q3);
        a4 = (TextView) findViewById(R.id.q4);
        a5 = (TextView) findViewById(R.id.q5);
        a6 = (TextView) findViewById(R.id.q6);
        a7 = (TextView) findViewById(R.id.q7);
        a8 = (TextView) findViewById(R.id.q8);
        a9 = (TextView) findViewById(R.id.q9);
        a10  = (TextView) findViewById(R.id.q10);
        a11 = (TextView) findViewById(R.id.q11);
        a12 = (TextView) findViewById(R.id.q12); ;
        a13  = (TextView) findViewById(R.id.q13);
        a14  = (TextView) findViewById(R.id.q14);
        a15 = (TextView) findViewById(R.id.q15);
        a16  = (TextView) findViewById(R.id.q16);
        a17 = (TextView) findViewById(R.id.q17);
        a18  = (TextView) findViewById(R.id.q18);
        a19  = (TextView) findViewById(R.id.q19);
        a20 = (TextView) findViewById(R.id.q20);
        displayView = (TextView) findViewById(R.id.score);
        mtrys =(TextView) findViewById(R.id.trys);
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        getBaseContext().getContentResolver().notifyChange(PetEntry.CONTENT_URI, null);
        backmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GroupEActivity.this,QuestionAcvtivity.class));
                finish();
            }
        });
// Kick off the loader
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
        startActivity(new Intent(GroupEActivity.this,QuestionAcvtivity.class));
        finish();
    }
    @Override
    protected void onStart() {
        // for rewarding video
        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",new AdRequest.Builder().build());
        super.onStart();
        getBaseContext().getContentResolver().notifyChange(PetEntry.CONTENT_URI, null);
        if(score>80){
            a1.setBackgroundColor(Color.parseColor("#FFE082"));
            a1.setTextColor(Color.parseColor("#000000"));
            a1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe1Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        }
        if(tr>0){
            if (score == 80) {
                a1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());
                        Intent questionintent = new Intent(GroupEActivity.this, Qe1Activity.class);
                        startActivity(questionintent);
                        finish();
                    }
                });
            }
        }else{

            a1.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });

        }

        if(tr>0){
            if(score==81){
                a2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe2Activity.class);

                        startActivity(questionintent);
                        finish();

                    }
                });
            }
        }else{
            a2.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<81){

            a2.setOnClickListener(new View.OnClickListener() {
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

        }if(score>81){

            a2.setBackgroundColor(Color.parseColor("#FFE082"));
            a2.setTextColor(Color.parseColor("#000000"));
            a2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe2Activity.class);
                    startActivity(questionintent);
                    finish();
                }
            });
        }
        //
        if(tr>0){
            if(score==82){
                a3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe3Activity.class);
                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a3.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<82){

            a3.setOnClickListener(new View.OnClickListener() {
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

        }if(score>82){

            a3.setBackgroundColor(Color.parseColor("#FFE082"));
            a3.setTextColor(Color.parseColor("#000000"));
            a3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe3Activity.class);
                    startActivity(questionintent);

                }
            });
        }
        //
        if(tr>0){
            if(score==83){

                a4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe4Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a4.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<83){

            a4.setOnClickListener(new View.OnClickListener() {
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

        }if(score>83){

            a4.setBackgroundColor(Color.parseColor("#FFE082"));
            a4.setTextColor(Color.parseColor("#000000"));
            a4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe4Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        }
        //
        if(tr>0){
            if(score==84){
                a5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe5Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a5.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<84){

            a5.setOnClickListener(new View.OnClickListener() {
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

        }if(score>84){

            a5.setBackgroundColor(Color.parseColor("#FFE082"));
            a5.setTextColor(Color.parseColor("#000000"));
            a5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe5Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        }
        //
        if(tr>0){
            if(score==85){
                a6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe6Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a6.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<85){

            a6.setOnClickListener(new View.OnClickListener() {
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

        }if(score>85){

            a6.setBackgroundColor(Color.parseColor("#FFE082"));
            a6.setTextColor(Color.parseColor("#000000"));
            a6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe6Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        }
        //
        if(tr>0){
            if(score==86){
                a7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe7Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a7.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<86){

            a7.setOnClickListener(new View.OnClickListener() {
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

        }if(score>86){

            a7.setBackgroundColor(Color.parseColor("#FFE082"));

            a7.setTextColor(Color.parseColor("#000000"));
            a7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe7Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        }
        //
        if(tr>0){
            if(score==87){
                a8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe8Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a8.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<87){

            a8.setOnClickListener(new View.OnClickListener() {
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

        }if(score>87 ){

            a8.setBackgroundColor(Color.parseColor("#FFE082"));
            a8.setTextColor(Color.parseColor("#000000"));
            a8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe8Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==88){
                a9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe9Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a9.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<88){

            a9.setOnClickListener(new View.OnClickListener() {
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

        }if(score>88 ){

            a9.setBackgroundColor(Color.parseColor("#FFE082"));
            a9.setTextColor(Color.parseColor("#000000"));
            a9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe9Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==89 ){
                a10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe10Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a10.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<89  ){

            a10 .setOnClickListener(new View.OnClickListener() {
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

        }if(score>89){

            a10 .setBackgroundColor(Color.parseColor("#FFE082"));
            a10 .setTextColor(Color.parseColor("#000000"));
            a10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe10Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==90    ){
                a11 .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe11Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a11 .setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<90){

            a11.setOnClickListener(new View.OnClickListener() {
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

        }if(score>90){

            a11 .setBackgroundColor(Color.parseColor("#FFE082"));

            a11.setTextColor(Color.parseColor("#000000"));
            a11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe11Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==91){
                a12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe12Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a12 .setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<91){

            a12.setOnClickListener(new View.OnClickListener() {
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

        }if(score>91){

            a12 .setBackgroundColor(Color.parseColor("#FFE082"));

            a12.setTextColor(Color.parseColor("#000000"));
            a12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe12Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==92){
                a13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe13Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a13.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<92){

            a13.setOnClickListener(new View.OnClickListener() {
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

        }if(score>92){

            a13.setBackgroundColor(Color.parseColor("#FFE082"));

            a13.setTextColor(Color.parseColor("#000000"));
            a13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe13Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==93){
                a14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe14Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a14.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<93){

            a14.setOnClickListener(new View.OnClickListener() {
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

        }if(score>93){

            a14.setBackgroundColor(Color.parseColor("#FFE082"));

            a14.setTextColor(Color.parseColor("#000000"));
            a14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe14Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==94){
                a15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe15Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a15.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<94){

            a15.setOnClickListener(new View.OnClickListener() {
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

        }if(score>94){

            a15.setBackgroundColor(Color.parseColor("#FFE082"));
            a15.setTextColor(Color.parseColor("#000000"));
            a15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe15Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==95){
                a16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe16Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a16.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<95){

            a16.setOnClickListener(new View.OnClickListener() {
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

        }if(score>95){

            a16.setBackgroundColor(Color.parseColor("#FFE082"));
            a16.setTextColor(Color.parseColor("#000000"));
            a16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe16Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==96){
                a17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe17Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a17.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<96){

            a17.setOnClickListener(new View.OnClickListener() {
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

        }if(score>96){

            a17.setBackgroundColor(Color.parseColor("#FFE082"));

            a17.setTextColor(Color.parseColor("#000000"));
            a17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe17Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==97){
                a18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe18Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a18 .setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<97 ){

            a18.setOnClickListener(new View.OnClickListener() {
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

        }if(score>97){

            a18.setBackgroundColor(Color.parseColor("#FFE082"));
            a18 .setTextColor(Color.parseColor("#000000"));
            a18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe18Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==98){
                a19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe19Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a19.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<98){

            a19.setOnClickListener(new View.OnClickListener() {
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

        }if(score>98){

            a19.setBackgroundColor(Color.parseColor("#FFE082"));
            a19.setTextColor(Color.parseColor("#000000"));
            a19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe19Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        if(tr>0){
            if(score==99){
                a20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                        Intent questionintent = new Intent(GroupEActivity.this, Qe20Activity.class);

                        startActivity(questionintent);
                        finish();
                    }
                });

            }
        }else{
            a20.setOnClickListener(new View.OnClickListener() {
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
                    trys_Gone(discardButtonClickListener);
                }
            });
        }

        if(score<99 ){

            a20.setOnClickListener(new View.OnClickListener() {
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

        }if(score>99){

            a20.setBackgroundColor(Color.parseColor("#FFE082"));
            a20 .setTextColor(Color.parseColor("#000000"));
            a20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRewardedVideoAd.loadAd("",new AdRequest.Builder().build());

                    Intent questionintent = new Intent(GroupEActivity.this, Qe20Activity.class);
                    startActivity(questionintent);
                    finish();

                }
            });
        } //
        // for rewarding vido
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
        });
    }
//    // for rewarding video
//    private void loadRewardedVideoAd() {
//        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
//                new AdRequest.Builder().build());
//    }

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
            int currentscore = cursor.getInt(scoreIndex);
            score =currentscore;

            // you must make some space
            displayView.setText(String.valueOf(score));
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
        boolean  flag =true;

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













