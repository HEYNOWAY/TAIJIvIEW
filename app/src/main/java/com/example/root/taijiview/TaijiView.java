package com.example.root.taijiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by root on 17-3-23.
 */

public class TaijiView extends View {
    private Paint whitePaint;
    private Paint blackPaint;
    private float degree = 0;

    public TaijiView(Context context) {
        this(context,null);
    }

    public TaijiView(Context context, AttributeSet attrs) {
        this(context, attrs,0);


    }

    public TaijiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
        whitePaint.setStrokeWidth(4);

        blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.FILL);
        blackPaint.setStrokeWidth(4);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureWidth = measureSpec(widthMeasureSpec);
        int measureHeight = measureSpec(heightMeasureSpec);
        setMeasuredDimension(measureWidth,measureHeight);

    }

    private int measureSpec(int spec) {
        int result;
        int measureMode = MeasureSpec.getMode(spec);
        int measureSize = MeasureSpec.getSize(spec);
        if(measureMode==MeasureSpec.EXACTLY){
            result = measureSize;
        } else {
            result = 400;
            if(measureMode==MeasureSpec.AT_MOST){
                result = Math.min(result,measureSize);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height =getHeight();

        canvas.translate(width/2,height/2);
        canvas.drawColor(Color.GRAY);
        canvas.rotate(degree);

        int radius = Math.min(width,height)/2;
        RectF rect = new RectF(-radius,-radius,radius,radius);
        canvas.drawArc(rect,-90,180,true,whitePaint);
        canvas.drawArc(rect,90,180,true,blackPaint);

        RectF smallRectWhite = new RectF(-radius/2,-radius,radius/2,0);
        RectF smallRectBlack = new RectF(-radius/2,0,radius/2,radius);
        canvas.drawArc(smallRectBlack,-90,180,true,blackPaint);
        canvas.drawArc(smallRectWhite,90,180,true,whitePaint);

        canvas.drawCircle(0,-radius/2,radius/8,blackPaint);
        canvas.drawCircle(0,radius/2,radius/8,whitePaint);
    }

    public void setDegree(float degree){
        this.degree = degree;
        invalidate();
    }


}
