package com.whitecatdeveloper.rgbcircles.view.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import com.whitecatdeveloper.rgbcircles.R;

public class GameModeActivity extends AppCompatActivity {
    Intent intentPlayGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
    }


    public void onClickEasyMode(View view) {
        intentPlay("easy");
    }

    public void onClickMediumMode(View view) {
        intentPlay("medium");
    }

    public void onClickHardMode(View view) {
        intentPlay("hard");
    }

    private void intentPlay (String mode) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("GameMode", mode);
        editor.apply();
        intentPlayGame =  new Intent(this, GameActivity.class);
        startActivity(intentPlayGame);
    }
}
