package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

import kotlin.random.Random


class Fragment3 : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_3, container, false)


        val diceImage = view.findViewById<ImageView>(R.id.dice)
        val player1Image = view.findViewById<ImageView>(R.id.player1)
        val rollBtn = view.findViewById<Button>(R.id.rollButton)
        val rollText = view.findViewById<TextView>(R.id.rollResult)
        val boardImage = view.findViewById<ImageView>(R.id.boardImage)

        val player1Text = view.findViewById<TextView>(R.id.player1Display)
        val player2Text = view.findViewById<TextView>(R.id.player2Display)

        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val player1Name = sharedPreferences.getString("Player 1", "")
        val player2Name = sharedPreferences.getString("Player 2", "")
        player1Text.text = player1Name
        player2Text.text = player2Name


        val snakeHead = intArrayOf(11,27,41,44,69,78,88,91,98)
        val snakeTail = intArrayOf(7,3,17,39,31,56,51,68,89,29)
        val ladderTop = intArrayOf(29,36,48,59,75,86,89,95,99)
        val ladderBottom = intArrayOf(8,26,32,23,45,74,70,64,80)

        var currentPos = 0



        rollBtn.setOnClickListener {
            val diceRoll = Random.nextInt(1, 7)


            currentPos += diceRoll

            val drawableResources = when (diceRoll){
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                else -> R.drawable.dice6
            }
            diceImage.setImageResource(drawableResources)


            val boardSize = 10



            for(i in snakeHead.indices){
                if(currentPos == snakeHead[i]){
                    currentPos = snakeTail[i]
                }
            }

            for(i in ladderBottom.indices){
                if(currentPos == ladderBottom[i]){
                    currentPos = ladderTop[i]
                }
            }

            val rollString = "$player1Name rolled a $diceRoll. You are now in tile $currentPos"
            rollText.text = rollString

            if(currentPos >= 100)
            {
                rollText.text = "You win!"
                currentPos = 100;

            }

        boardImage.post{

            val boardWidth = boardImage.width
            val boardHeight = boardImage.height

            val direction = if((currentPos - 1) /  10 % 2 == 0) {
                1
            }
            else{
                -1
            }

            val xPosition = if(direction == 1){
                ((currentPos - 1) % boardSize) * boardWidth / boardSize
                }
            else
            {
                (boardSize - (currentPos - 1) % boardSize - 1) * boardWidth / boardSize
            }

            val yPosition = ((boardSize + 2) - (currentPos - 1) / boardSize) * boardHeight / boardSize

            player1Image.x = xPosition.toFloat()
            player1Image.y = yPosition.toFloat()

        }

        }

        return view
    }
    }