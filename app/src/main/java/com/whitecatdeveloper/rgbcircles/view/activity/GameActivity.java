package com.whitecatdeveloper.rgbcircles.view.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.whitecatdeveloper.rgbcircles.view.CanvasView;

public class GameActivity extends AppCompatActivity {

    private static String gameMode;
    private CanvasView canvasView;
    private static int colorMainCircle;
    private static int colorBackgroundGame;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSettings();
        canvasView = new CanvasView(this);
        setContentView(canvasView);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();

    }

    public static int getColorMainCircle() {
        return colorMainCircle;
    }

    public static int getColorBackgroundGame() {
        return colorBackgroundGame;
    }

    public static String getGameMode() {
        return gameMode;
    }

    public void returnMain() {
        Intent intentReturnMain = new Intent(this, MainActivity.class);
        startActivity(intentReturnMain);
    }

    @Override
    public void onBackPressed() {
        canvasView.gamePause(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ПАУЗА");
        builder.setPositiveButton("Продолжить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                canvasView.gamePause(true);
            }
        });
        builder.setNegativeButton("ВЫЙТИ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                returnMain();
            }
        });
        builder.show();
    }

    private void getSettings () {
        sharedPreferences = getSharedPreferences("MySettings", MODE_PRIVATE);
        colorMainCircle = sharedPreferences.getInt("colorMainCircle", Color.BLUE);
        colorBackgroundGame = sharedPreferences.getInt("colorBackgroundGame", Color.WHITE);
        gameMode = sharedPreferences.getString("GameMode", "easy");
        Log.e("ERRR", gameMode);
    }


}
