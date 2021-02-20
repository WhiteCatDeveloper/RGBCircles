package com.whitecatdeveloper.rgbcircles.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.whitecatdeveloper.rgbcircles.game.GameManager;
import com.whitecatdeveloper.rgbcircles.game.SimpleCircle;
import com.whitecatdeveloper.rgbcircles.view.activity.GameActivity;
import com.whitecatdeveloper.rgbcircles.view.activity.MainActivity;

public class CanvasView extends View  implements ICanvasView{
    private static int width;
    private static int height;
    private GameManager gameManager;
    private Paint paint;
    private Canvas canvas;

    public CanvasView(Context context) {
        super(context);
        initWidthAndHeight(context);
        gameManager = new GameManager(this, width, height);
    }

    private void initWidthAndHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        initPaint();
        width = point.x;
        height = point.y;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        paint.setColor(GameActivity.getColorBackgroundGame());
        canvas.drawPaint(paint);
        drawScore(canvas);
        drawTimer(canvas);
        gameManager.onDraw();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void showMessage(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(text);
        builder.setMessage("Набрано очков: " + gameManager.getScore() + "\n" + "Осталось времени: " + gameManager.getSecondToEndGame());
        builder.setPositiveButton("ЗАНОВО", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gameManager.newGame();
            }
        });
        builder.setNegativeButton("ВЫЙТИ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             }
        });
        builder.show();
    }

    @Override
    public void redraw() {
        invalidate();
    }

    @Override
    public void drawCircle(SimpleCircle circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if(event.getAction() == MotionEvent.ACTION_MOVE) gameManager.onTouchEvent(x, y);
        invalidate();
        return true;
    }

    public void gamePause(boolean pause) {
        gameManager.setRunning(pause);
    }

    private void drawScore (Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        paint.setAntiAlias(true);
        paint.setTextSize(40);
        canvas.drawText("ОЧКИ: " + gameManager.getScore(), 40, 100, paint);
    }

    private void drawTimer (Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        paint.setAntiAlias(true);
        paint.setTextSize(40);
        canvas.drawText("ВРЕМЯ: " + gameManager.getSecondToEndGame(), 400, 100, paint);
    }
}
