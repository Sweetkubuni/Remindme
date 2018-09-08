package com.kubuni.test.remindme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by justi on 8/13/2018.
 */

public class Alarm_Receiver  extends BroadcastReceiver{
    private static final String TAG = " BroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "We're in the Reciever");
    }
}
