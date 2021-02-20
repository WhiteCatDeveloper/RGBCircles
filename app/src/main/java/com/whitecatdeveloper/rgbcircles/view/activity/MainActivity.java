package com.whitecatdeveloper.rgbcircles.view.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.whitecatdeveloper.rgbcircles.R;
import com.whitecatdeveloper.rgbcircles.view.CanvasView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
    }


    public void onClickPlayGame(View view) {
        Intent intentPlayGame = new Intent(MainActivity.this, GameActivity.class);
        intentPlayGame.putExtra("mode", "easy");
        startActivity(intentPlayGame);
    }

    public void onClickGameMode(View view) {
        Intent intentGameMode = new Intent(MainActivity.this, GameModeActivity.class);
        startActivity(intentGameMode);
    }

    public void onClickAchievements(View view) {
        Intent intentAchievements = new Intent(MainActivity.this, AchievementsActivity.class);
        startActivity(intentAchievements);
    }

    public void onClickSettings(View view) {
        Intent intentSettings = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intentSettings);
    }
}
