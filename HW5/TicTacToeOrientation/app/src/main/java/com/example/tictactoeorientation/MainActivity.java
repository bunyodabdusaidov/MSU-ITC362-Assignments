package com.example.tictactoeorientation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private TicTacToe tttGame;
    private ButtonGridAndTextView tttView;
    private int w;
    Point size = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        tttGame = new TicTacToe();
        getWindowManager().getDefaultDisplay().getSize(size);
        modifySize(config, size.x);
        modifyPadding(config, size.x);
        tttView.setStatusText(tttGame.result());
        setContentView(tttView);
    }

    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
        modifySize(config, size.x);
        modifyPadding(config, size.x);
    }

    private void modifySize(Configuration config, int x) {
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            w = x / 9;
            ButtonHandler bh = new ButtonHandler();
            tttView = new ButtonGridAndTextView(this, w, TicTacToe.SIDE, bh);
        } else if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            w = x / TicTacToe.SIDE;
            ButtonHandler bh = new ButtonHandler();
            tttView = new ButtonGridAndTextView(this, w, TicTacToe.SIDE, bh);
        }
    }

    private void modifyPadding(Configuration config, int x) {
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tttView.setPadding((x*3), 20, 0, 0);
        } else if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            tttView.setPadding(0,0,0,0);
        }
    }

    public void showNewGameDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("This is fun");
        alert.setMessage("Play again?");
        PlayDialog playAgain = new PlayDialog();
        alert.setPositiveButton("YES", playAgain);
        alert.setNegativeButton("NO", playAgain);
        alert.show();
    }

    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            for (int row = 0; row < TicTacToe.SIDE; row++) {
                for (int column = 0; column < TicTacToe.SIDE; column++) {
                    if (tttView.isButton((Button) view, row, column)) {
                        int play = tttGame.play(row, column);
                        if (play == 1)
                            tttView.setButtonText(row, column, "X");
                        else if (play == 2)
                            tttView.setButtonText(row, column, "O");
                        if (tttGame.isGameOver()) {
                            tttView.setStatusBackgroundColor(Color.RED);
                            tttView.enableButtons(false);
                            tttView.setStatusText(tttGame.result());
                            showNewGameDialog();
                        }
                    }
                }
            }
        }
    }

    private class PlayDialog implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int id) {
            if (id == -1) /* YES button */ {
                tttGame.resetGame();
                tttView.enableButtons(true);
                tttView.resetButtons();
                tttView.setStatusBackgroundColor(Color.GREEN);
                tttView.setStatusText(tttGame.result());
            }
            else if (id == -2) // No Button
                MainActivity.this.finish();
        }
    }
}