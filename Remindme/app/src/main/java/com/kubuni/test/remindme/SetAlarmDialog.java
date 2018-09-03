package com.kubuni.test.remindme;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by justi on 7/11/2018.
 */

public class SetAlarmDialog extends DialogFragment {
    private static final String TAG = "SetAlarmDialog";
    private Button mActionCancel;
    private Button mActionSubmit;
    private Button mMondayButton;
    private Button mTuesdayButton;
    private Button mWednesdayButton;
    private Button mThursdayButton;
    private Button mFridayButton;
    private Button mSaturdayButton;
    private Button mSundayButton;
    private Calendar cal;


    private TimePicker timeselect;

    public interface OnInputListener {
        void createAlarm( Calendar input);
    }

    public OnInputListener mOnInputListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_addalarm, container, false );

        timeselect = view.findViewById(R.id.timePicker);
        mActionSubmit = view.findViewById(R.id.Submitaddalarm);
        mActionCancel = view.findViewById(R.id.Canceladdalarm);
        mMondayButton = view.findViewById(R.id.MondayButton);
        mTuesdayButton = view.findViewById(R.id.TuesdayButton);

        cal = Calendar.getInstance();

        //create events

        mMondayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            }
        });

        mActionCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG, "onClick: Canceling Dialog");
                getDialog().dismiss();
            }
        });

        mActionSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG, "onClick: Dialog Submitting Calender info ");
                cal.set(Calendar.HOUR_OF_DAY, timeselect.getCurrentHour());
                cal.set(Calendar.MINUTE, timeselect.getCurrentMinute());
                mOnInputListener.createAlarm(cal);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mOnInputListener = (OnInputListener)getActivity();
        }
        catch(ClassCastException e){
            Log.d(TAG, "OnAttach: ClassCastException : " + e.getMessage());
        }
    }
}
