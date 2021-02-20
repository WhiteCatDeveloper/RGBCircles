package com.whitecatdeveloper.rgbcircles.game;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

import com.whitecatdeveloper.rgbcircles.view.CanvasView;
import com.whitecatdeveloper.rgbcircles.view.activity.GameActivity;

import java.util.ArrayList;

public class GameManager {
    private CanvasView canvasView;
    private ArrayList<EnemyCircle> circles;
    private static int width;
    private static int height;
    private MainCircle mainCircle;
    CountDownTimer gameTimer;
    private int secondToEndGame;
    private boolean isRunning;
    private int sumCircles;
    private int speedGame;
    private int colorMainCircle;
    private int score;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        colorMainCircle = GameActivity.getColorMainCircle();
        newGame();
    }

    private void initEnemyCircle() {
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        circles = new ArrayList<>();
            while (circles.size() < sumCircles) {
                EnemyCircle circle = EnemyCircle.getRandomCircle();
                if (!circle.isIntersect(mainCircleArea))  circles.add(circle);
            }
        calculateAndSetCircleColor();
    }

    private void calculateAndSetCircleColor() {
        for(EnemyCircle circle : circles) {
            circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2, colorMainCircle);
    }



    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircle(x, y);
    }

    private void checkCollision() {
        SimpleCircle circleForDel = null;
        for (EnemyCircle circle : circles) {
            if (mainCircle.isIntersect(circle)) {
                if (circle.isSmallerThan(mainCircle)){
                    mainCircle.growRadius(circle);
                    circleForDel = circle;
                    calculateAndSetCircleColor();
                    score++;
                    break;
                } else {
                    canvasView.showMessage("ВЫ ПРОИГРАЛИ!");
                    isRunning = false;
                    gameTimer.cancel();
                }
                return;
            }
        }
        if (circleForDel != null)  circles.remove(circleForDel);
        if (circles.isEmpty()) {
            canvasView.showMessage("ВЫ ВЫИГРАЛИ!");
            isRunning = false;
            gameTimer.cancel();
        }
    }

    public void newGame() {
            getModeGame();
            initMainCircle();
            initEnemyCircle();
            canvasView.redraw();
            isRunning = true;
            score = 0;
            moveCircles();
            timerManager();
    }

    private void moveCircles() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    for(EnemyCircle circle : circles) {
                        circle.moveOneStep();
                        canvasView.invalidate();
                    }
                    checkCollision();
                    handler.postDelayed(this, speedGame);

                }
            }
        });
    }

    private void getModeGame() {
        GameModeFactory factory = new GameModeFactory(GameActivity.getGameMode());
        sumCircles = factory.getCirclesSum();
        speedGame = factory.getGameSpeed();
        secondToEndGame = factory.getTimeOfTheGame();
    }

    public void setRunning(boolean running) {
        isRunning = running;
        if (isRunning) {
            moveCircles();
            gameTimer.start();
        } else gameTimer.cancel();
    }

    public int getScore() {
        return score;
    }


    private void timerManager () {
            gameTimer = new CountDownTimer(secondToEndGame * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondToEndGame--;
                Log.e("ERRR", String.valueOf(secondToEndGame));
            }

            @Override
            public void onFinish() {
                canvasView.showMessage("Время вышло!");
                isRunning = false;
            }
        };
            gameTimer.start();
    }

    public int getSecondToEndGame() {
        return secondToEndGame;
    }
}
