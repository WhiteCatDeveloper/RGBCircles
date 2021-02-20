package com.whitecatdeveloper.rgbcircles.view.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.whitecatdeveloper.rgbcircles.R;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioGroupSetColorBackgroundGame;
    private RadioGroup radioGroupSetColorMainCircle;

    private int colorBackgroundGame;
    private int colorMainCircle;

    public SharedPreferences sharedPreferencesSettings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
        initRButton();
    }

    public void onClickSaveSettings(View view) {
        saveSettings();
        goToMain();
    }


    public void onClickToMain(View view) {
        goToMain();
    }

    public void onClickInfoOfWhiteCat(View view) {
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    private void getBackgroundColor () {
       int checkedColorBackground = radioGroupSetColorBackgroundGame.getCheckedRadioButtonId();
       switch (checkedColorBackground) {
           case R.id.radioButtonSetBackgroundWithe : colorBackgroundGame = Color.WHITE;
           break;
           case R.id.radioButtonSetBackgroundGreen : colorBackgroundGame = Color.GREEN;
           break;
           case R.id.radioButtonSetBackgroundYellow : colorBackgroundGame = Color.YELLOW;
           break;
           default: colorBackgroundGame = Color.BLACK;
       }
    }

    private void getMAinCircleColor () {
        int checkedColorMainCircle = radioGroupSetColorMainCircle.getCheckedRadioButtonId();
        switch (checkedColorMainCircle) {
            case R.id.radioButtonSetColorMainCircleBlue: colorMainCircle = Color.parseColor("#2818B1");
            break;
            case  R.id.radioButtonSetColorMainCircleGreen: colorMainCircle = Color.parseColor("#00CC00");
            break;
            case R.id.radioButtonSetColorMainCircleOrange : colorMainCircle = Color.parseColor("#FF7F00");
            break;
            default: colorMainCircle = Color.BLACK;
        }
    }

    private void saveSettings() {
        getBackgroundColor();
        getMAinCircleColor();
        sharedPreferencesSettings  = getSharedPreferences("MySettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesSettings.edit();
        editor.putInt("colorMainCircle", colorMainCircle);
        editor.putInt("colorBackgroundGame", colorBackgroundGame);
        editor.apply();
    }

    private void initRButton() {
        radioGroupSetColorBackgroundGame = findViewById(R.id.radioGroupSetColorBackgroundGame);
        radioGroupSetColorMainCircle = findViewById(R.id.radioGroupSetColorMainCircle);
    }

}
