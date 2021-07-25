package com.droidcoder.rockpaperscissors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.droidcoder.rockpaperscissors.databinding.ActivityMainBinding
import java.lang.Math.random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeViews()
    }

    private fun initializeViews() {
        binding.rockButton.setOnClickListener { handleHand(Hand.ROCK) }
        binding.paperButton.setOnClickListener { handleHand(Hand.PAPER) }
        binding.scissorButton.setOnClickListener { handleHand(Hand.SCISSOR) }
    }

    private fun handleHand(hand: Hand) {
        val result = createResult()
        binding.resultText.setImageDrawable(ContextCompat.getDrawable(this, result.resourceId))
        when (result) {
            Result.WIN -> when (hand) {
                Hand.ROCK -> setOpponentHand(Hand.SCISSOR)
                Hand.PAPER -> setOpponentHand(Hand.ROCK)
                Hand.SCISSOR -> setOpponentHand(Hand.PAPER)
            }
            Result.DRAW -> when (hand) {
                Hand.ROCK -> setOpponentHand(Hand.ROCK)
                Hand.PAPER -> setOpponentHand(Hand.PAPER)
                Hand.SCISSOR -> setOpponentHand(Hand.SCISSOR)
            }
            Result.LOSE -> when (hand) {
                Hand.ROCK -> setOpponentHand(Hand.PAPER)
                Hand.PAPER -> setOpponentHand(Hand.SCISSOR)
                Hand.SCISSOR -> setOpponentHand(Hand.ROCK)
            }
        }
    }

    private fun createResult(): Result {
        return Result.values()[(random() * 3).toInt()]
    }

    private fun setOpponentHand(hand: Hand) {
        when (hand) {
            Hand.ROCK -> binding.opponentHand.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.chicken_rock
                )
            )
            Hand.PAPER -> binding.opponentHand.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.chicken_paper
                )
            )
            Hand.SCISSOR -> binding.opponentHand.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.chicken_scissors
                )
            )
        }
    }
}
