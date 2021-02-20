package com.whitecatdeveloper.rgbcircles.view.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.whitecatdeveloper.rgbcircles.R;

public class AchievementsActivity extends AppCompatActivity {

    LinearLayout linearLayoutArrayAchievements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
        linearLayoutArrayAchievements = findViewById(R.id.linearLayoutArrayAchievements);
    }


}
