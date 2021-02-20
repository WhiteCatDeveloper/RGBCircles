package com.whitecatdeveloper.rgbcircles.view;

import com.whitecatdeveloper.rgbcircles.game.MainCircle;
import com.whitecatdeveloper.rgbcircles.game.SimpleCircle;

public interface ICanvasView {
    void drawCircle(SimpleCircle circle);

    void redraw();

    void showMessage(String text);
}
