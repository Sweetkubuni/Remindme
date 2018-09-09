package com.kubuni.test.remindme;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by justi on 9/4/2018.
 */

public class AlarmSlot extends View {

    String TimeStr;

    public AlarmSlot(Context context) {
        super(context);
    }

    public AlarmSlot(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AlarmSlot(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void DrawCenterText(Canvas canvas, Paint paint, String text)
    {
        Rect r = new Rect();
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.getTextBounds(text, 0, text.length(), r);
        //float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, 30, y, paint);
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
        TextColor.setColor(Color.DKGRAY);
        TextColor.setTextSize(50);
        canvas.drawRoundRect(Background, 10, 10, BackgroundColor);

        TimeStr = new String("12:00 PM");
        DrawCenterText(canvas, TextColor, TimeStr);
        //int yPos = (int) ((canvas.getHeight() / 2) - ((TextColor.descent() + TextColor.ascent()) / 2)) ;
        //canvas.drawText(TimeStr, 10, yPos, TextColor);
    }
}
