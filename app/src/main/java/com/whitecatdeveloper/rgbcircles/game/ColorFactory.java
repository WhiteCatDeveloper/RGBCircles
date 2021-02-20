package com.whitecatdeveloper.rgbcircles.game;

import android.graphics.Color;

public class ColorFactory {
    private int color;

    public ColorFactory (String getColor) {
        switch (getColor) {
            case "": color = Color.parseColor("#FFFFFF");
        }
    }
}
