package com.example.dinogame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GameStart : AppCompatActivity(), View.OnClickListener {
    private val buttons = Array<Array<Button?>>(3) { arrayOfNulls(3) }
    private var turn = true
    private var roundCount: Int = 0
    private var p1pts: Int = 0
    private var p2pts: Int = 0
    private var player1Score: TextView? = null
    private var player2Score: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tictacgeoff)

        player1Score = findViewById(R.id.text_view_p1)
        player2Score = findViewById(R.id.text_view_p2)

        for (i in 0..2) {
            for (j in 0..2) {
                val buttonIDs = "button_$i$j"
                val res = resources.getIdentifier(buttonIDs, "id", this.packageName)
                buttons[i][j] = findViewById<Button>(res)
                buttons[i][j]?.setOnClickListener(this)
                buttons[i][j]?.setBackgroundResource(android.R.drawable.btn_default)
            }
        }
        val reset = findViewById<Button>(R.id.button_reset)

        reset.setOnClickListener { resetScore() }
    }


    private fun player1Wins() {
        p1pts++
        Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show()
        update()
        resetScore()
    }

    private fun player2Wins() {
        p2pts++
        Toast.makeText(this, "Geoff wins!", Toast.LENGTH_SHORT).show()
        update()
        resetScore()
    }

    private fun draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show()
        resetScore()
    }

    private fun update() {
        player1Score!!.text = StringBuilder().append("Player 1 : ").append(p1pts).toString()
        player2Score!!.text = StringBuilder().append("Geoff : ").append(p2pts).toString()
    }

    private fun resetScore() {
        for (x in 0..2) {
            for (y in 0..2) {
                buttons[x][y]?.text = ""
                buttons[x][y]?.setBackgroundResource(android.R.drawable.btn_default)
                buttons[x][y]?.visibility = View.VISIBLE
            }
        }
        player1Score!!.text = StringBuilder().append("Player 1 : ").append(0).toString()
        player2Score!!.text = StringBuilder().append("Geoff : ").append(0).toString()
        roundCount = 0
        turn = true
    }

    // Winning Logic Taken from:
    // https://codinginflow.com/tutorials/android/tic-tac-toe/part-2-winning-logic

    private val size = 3

    private fun winChecker(): Boolean {
        val field = Array<Array<String?>>(3) {
            arrayOfNulls(size)
        }

        for (i in 0..2) {
            for (j in 0..2) {
                field[i][j] = buttons[i][j]?.text.toString()
            }
        }

        for (i in 0..2) {
            if (field[i][0] == field[i][1]
                    && field[i][0] == field[i][2]
                    && field[i][0] != "") {
                return true
            }
        }

        for (i in 0..2) {
            if (field[0][i] == field[1][i]
                    && field[0][i] == field[2][i]
                    && field[0][i] != "") {
                return true
            }
        }

        return if (field[0][0] == field[1][1]
                && field[0][0] == field[2][2]
                && field[0][0] != "") {
            true
        } else field[0][2] == field[1][1]
                && field[0][2] == field[2][0]
                && field[0][2] != ""

    }

    override fun onClick(v: View) {
        if ((v as Button).text.toString() != "") {
            return
        }
        if (turn) {
            //adding a text to the tictactoe game
            v.text = "X"
            v.setBackgroundResource(R.drawable.cs125photo)
        } else {
            v.text = "O"
            v.setBackgroundResource(R.drawable.geoffc)
        }
        roundCount++

        if (winChecker()) {
            if (turn) {
                player1Wins()
                startActivity(Intent(this, CameraPage::class.java))
            } else {
                player2Wins()
                startActivity(Intent(this, GeoffFace::class.java))
            }
        } else if (roundCount == 9) {
            draw()
        } else {
            turn = !turn
        }
    }
}
