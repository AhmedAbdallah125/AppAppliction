package com.example.compuworld.learnforkids;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.example.compuworld.learnforkids.data.PetContract.PetEntry;
import static com.example.compuworld.learnforkids.program.tr;

public class Alarm_trys extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//
        tr =5;
        ContentValues contentValues =new ContentValues();
        contentValues.put(PetEntry.PET_COLUMN_NAME,tr);
        context.getContentResolver().update(PetEntry.CONTENT_URI,contentValues,null,null);

        Toast.makeText(context,"done",Toast.LENGTH_SHORT).show();
    }

}
