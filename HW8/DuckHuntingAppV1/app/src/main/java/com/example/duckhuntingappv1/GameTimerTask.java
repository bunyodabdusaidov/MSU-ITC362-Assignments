package com.example.duckhuntingappv1;

import java.util.TimerTask;

public class GameTimerTask extends TimerTask {
    private Game game;
    private GameView gameView;

    public GameTimerTask(GameView view) {
        gameView = view;
        game = view.getGame();
        game.startDuckFromRightTopHalf();
    }

    @Override
    public void run() {
        game.moveDuck();
        if (game.duckOffScreen())
            game.startDuckFromRightTopHalf();
        gameView.postInvalidate();
    }
}
