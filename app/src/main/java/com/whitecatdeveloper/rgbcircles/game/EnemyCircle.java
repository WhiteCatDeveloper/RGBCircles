package com.whitecatdeveloper.rgbcircles.game;

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {


    private static final int TO_RADIUS = 100;
    private static final int FROM_RADIUS = 10;
    private static final int ENEMY_COLOR = Color.RED;
    private static final int FOOD_COLOR = Color.GREEN;
    public static final int RANDOM_SPEED = 10;

    private int dx;
    private int dy;

    private EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }


    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        return new EnemyCircle(x, y, radius, dx, dy);
    }

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if(isSmallerThan(mainCircle)) {
           setColor(FOOD_COLOR);
        } else setColor(ENEMY_COLOR);
    }

    boolean isSmallerThan(SimpleCircle circle) {
        return getRadius() < circle.getRadius();
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x > GameManager.getWidth() || x < 0) dx = - dx;
        if (y > GameManager.getHeight() || y < 0) dy = - dy;
    }
}
