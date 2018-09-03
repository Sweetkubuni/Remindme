package com.kubuni.test.remindme;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends Activity implements SetAlarmDialog.OnInputListener {
    AlarmManager alarm_manager;
    ArrayList<PendingIntent> intentArray;
    Context context;
    static int pendIntentCounter = 0;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;
        Button addNewAlarm = findViewById(R.id.addAlarm);

        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        addNewAlarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "onClick: Opening Dialog");

                SetAlarmDialog dialog = new SetAlarmDialog();
                dialog.show(getFragmentManager(), "SetAlarmDialog");
            }
        });
    }


    @Override
    public void createAlarm(Calendar input) {
        Log.d(TAG, "sendInput: Got the input: " + input.toString());
        Intent intent = new Intent(context, Alarm_Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, pendIntentCounter, intent, 0);
        alarm_manager.setRepeating(alarm_manager.RTC_WAKEUP, input.getTimeInMillis(), 1000 * 60 * 20, pendingIntent);
        intentArray.add(pendingIntent);
        ++pendIntentCounter;
    }
}
