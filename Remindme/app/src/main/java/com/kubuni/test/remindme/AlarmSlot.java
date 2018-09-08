package com.kubuni.test.remindme;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by justi on 9/4/2018.
 */

public class AlarmSlot extends View {

    String TimeStr;
    public AlarmSlot(Context context){
        super(context, null);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int canvasWidth = canvas.getWidth();
        final int canvasHeight = canvas.getHeight();

        RectF Background = new RectF();
        Background.set(0f,0f, canvasWidth, canvasHeight);
        int cornerRadius = Math.round(2f * getResources().getDisplayMetrics().scaledDensity);

        Paint BackgroundColor = new Paint(Paint.ANTI_ALIAS_FLAG);
        BackgroundColor.setColor(Color.WHITE);

        Paint TextColor = new Paint(Paint.ANTI_ALIAS_FLAG);
        TextColor.setColor(Color.LTGRAY);
        canvas.drawRoundRect(Background, 0.4f, 0.4f, BackgroundColor);

        TimeStr = new String("12:00 PM");
        canvas.drawText(TimeStr, 200, 200, TextColor);
    }
}
