package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    enum class Turn{
        NOUGHT,
        CROSS
    }

    companion object {
        const val NOUGHT = "O"
        const val CROSS = "X"
    }

    private var firstTurn = Turn.NOUGHT
    private var currentTurn = Turn.CROSS

    private var boardList = mutableListOf<Button>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()
    }

    private fun initBoard() {
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
    }

    fun boardTapped(view: View) {
        if(view !is Button) {
            return
        }
        addToBoard(view)
    }

    private fun addToBoard(button: Button) {
        if(button.text != "") {
            return
        }
        if(currentTurn == Turn.NOUGHT) {
            button.text = NOUGHT
            currentTurn = Turn.CROSS
        }
        else if(currentTurn == Turn.CROSS) {
            button.text = CROSS
            currentTurn = Turn.NOUGHT
        }
        setTurnLabel()
    }

    private fun setTurnLabel() {
        var turnText = ""
        if(currentTurn == Turn.NOUGHT) {
            turnText = "Turn $NOUGHT"
        }
        else if(currentTurn == Turn.CROSS) {
            turnText = "Turn $CROSS"
        }
        binding.tvTurn.text = turnText
    }


}