package com.example.compuworld.learnforkids;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;

public class program extends AppCompatActivity {

     static int score ;
     static int tr;
    static int va;
    static int vb;
    public void showUnsavedChangesDialog(

            DialogInterface.OnClickListener discardButtonClickListener) {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        // Get the layout inflater


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        builder.setView(getLayoutInflater().inflate(R.layout.dialog_signal,null));
        builder.setPositiveButton("OK",discardButtonClickListener);


        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void showWrongAnswer(

            DialogInterface.OnClickListener discardButtonClickListener) {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        // Get the layout inflater


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        builder.setView(getLayoutInflater().inflate(R.layout.wrong_answer,null));
        builder.setNeutralButton("   OK   ",discardButtonClickListener);


        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    // when trys is gone before question
    public void trys_Gone(

            DialogInterface.OnClickListener discardButtonClickListener) {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        // Get the layout inflater


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        builder.setView(getLayoutInflater().inflate(R.layout.trys_gone,null));
        builder.setNeutralButton("   OK   ",discardButtonClickListener);


        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    // when your trys closed in question
    public void gone(

            DialogInterface.OnClickListener discardButtonClickListener) {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        // Get the layout inflater


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        builder.setView(getLayoutInflater().inflate(R.layout.gone,null));
        builder.setNeutralButton("   OK   ",discardButtonClickListener);


        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // add helpes
    public void noHelpedAvailable(

            DialogInterface.OnClickListener discardButtonClickListener) {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        // Get the layout inflater


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        builder.setView(getLayoutInflater().inflate(R.layout.no_available,null));
        builder.setNeutralButton("   OK   ",discardButtonClickListener);


        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }





  }
