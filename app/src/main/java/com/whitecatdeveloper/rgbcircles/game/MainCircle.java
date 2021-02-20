package com.whitecatdeveloper.rgbcircles.game;


import android.graphics.Color;

import com.whitecatdeveloper.rgbcircles.R;

public class MainCircle extends SimpleCircle {



    public MainCircle(int x, int y, int color) {
        super(x, y, RADIUS_MAIN_CIRCLE);
        setColor(color);
    }

    private static final int RADIUS_MAIN_CIRCLE = 50;
    private static final int MAIN_SPEED = 30;

    public void moveMainCircle(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;
    }

    public void initRadius() {
        radius = RADIUS_MAIN_CIRCLE;
    }

    public void growRadius(SimpleCircle circle) {
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(circle.radius, 2));

    }
}
