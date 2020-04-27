/**
package com.example.dinogame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameStart extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];

    private boolean turn = true;

    private int roundCount;

    private int p1pts;
    private int p2pts;

    private TextView player1Score;
    private TextView player2Score;
    ImageView theView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictacgeoff);

        player1Score = findViewById(R.id.text_view_p1);
        player2Score = findViewById(R.id.text_view_p2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonIDs = "button_" + i + j;
                int res = getResources().getIdentifier(buttonIDs, "id", this.getPackageName());
                buttons[i][j] = findViewById(res);
                System.out.println(buttons[i][j]);
                buttons[i][j].setOnClickListener(this);
                buttons[i][j].setBackgroundResource(android.R.drawable.btn_default);
            }
        }
        Button reset = findViewById(R.id.button_reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScore();
            }
        });
    }


    private void player1Wins() {
        p1pts++;
        Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show();
        update();
        resetScore();
    }

    private void player2Wins() {
        p2pts++;
        Toast.makeText(this, "Geoff wins!", Toast.LENGTH_SHORT).show();
        update();
        resetScore();
    }

    private void draw() {
        Toast.makeText(this,"Draw!", Toast.LENGTH_SHORT).show();
        resetScore();
    }

    private void update() {
        player1Score.setText(new StringBuilder().append("Player 1 : ").append(p1pts).toString());
        player2Score.setText(new StringBuilder().append("Geoff : ").append(p2pts).toString());
    }

    private void resetScore() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                buttons[x][y].setText("");
                buttons[x][y].setBackgroundResource(android.R.drawable.btn_default);
                buttons[x][y].setVisibility(View.VISIBLE);
            }
        }
        player1Score.setText(new StringBuilder().append("Player 1 : ").append(0).toString());
        player2Score.setText(new StringBuilder().append("Geoff : ").append(0).toString());
        roundCount = 0;
        turn = true;
    }

    // Winning Logic Taken from:
    // https://codinginflow.com/tutorials/android/tic-tac-toe/part-2-winning-logic
    private boolean winChecker() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }

        return field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("");
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        //CameraPage forImage = new CameraPage();
//        BitmapDrawable you = new BitmapDrawable(getResources(),);
        //LinearLayout root = (LinearLayout) findViewById(R.id.gameboard);
        //root.setBackground(you);
        //theView.setBackground(you);
        if (turn) {
            //adding a text to the tictactoe game
            ((Button) v).setText("X");
            v.setBackgroundResource(R.drawable.cs125photo);
        } else {
            ((Button) v).setText("O");
            (v).setBackgroundResource(R.drawable.geoffc);
        }
        roundCount++;

        if (winChecker()) {
            if (turn) {
                player1Wins();
                startActivity(new Intent(this, CameraPage.class));
            } else {
                player2Wins();
                startActivity(new Intent(this, GeoffFace.class));
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            turn = !turn;
        }
    }
}
 **/
