package com.whitecatdeveloper.rgbcircles.game;

public class GameModeFactory {

    private int circlesSum;
    private int gameSpeed;
    private int timeOfTheGame;

    public GameModeFactory (String mode) {
        switch (mode) {
            case "hard": circlesSum = 18; gameSpeed = 10; timeOfTheGame = 30;
            break;
            case "medium" : circlesSum = 12; gameSpeed = 50; timeOfTheGame = 40;
            break;
            default: circlesSum = 8; gameSpeed = 100; timeOfTheGame = 50;
        }
    }

    public int getCirclesSum() {
        return circlesSum;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public int getTimeOfTheGame() {
        return timeOfTheGame;
    }
}
