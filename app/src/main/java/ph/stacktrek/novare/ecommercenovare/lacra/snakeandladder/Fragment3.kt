package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import kotlin.random.Random


class Fragment3 : Fragment() {

    private var totalScore = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_3, container, false)

        val diceImage = view.findViewById<ImageView>(R.id.dice)
        val rollBtn = view.findViewById<Button>(R.id.rollButton)
        val rollText = view.findViewById<TextView>(R.id.rollResult)


        rollBtn.setOnClickListener {
            val random = Random.nextInt(1, 7)
            totalScore += random
            val rollString = "You rolled a $random. You are now in tile $totalScore"
            rollText.text = rollString
            val drawableResources = when (random){
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                else -> R.drawable.dice6
            }
            diceImage.setImageResource(drawableResources)

            if (totalScore >= 100)
            {
                rollText.text = "You win!"
            }




        }
        return view
    }
    }