package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.random.Random


class ThreePlayerGame : Fragment() {



    private var player1Name: String? = null
    private var player2Name: String? = null
    private var player3Name: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game3players, container, false)


        val diceImage = view.findViewById<ImageView>(R.id.dice)
        val player1Image = view.findViewById<ImageView>(R.id.player1)
        val player2Image = view.findViewById<ImageView>(R.id.player2)
        val player3Image = view.findViewById<ImageView>(R.id.player3)
        val rollBtn = view.findViewById<Button>(R.id.rollButton)
        val rollText = view.findViewById<TextView>(R.id.rollResult)
        val turnText = view.findViewById<TextView>(R.id.playerTurn)
        val boardImage = view.findViewById<ImageView>(R.id.boardImage)

        val player1Text = view.findViewById<TextView>(R.id.player1Display)
        val player2Text = view.findViewById<TextView>(R.id.player2Display)
        val player3Text = view.findViewById<TextView>(R.id.player3Display)
        val player1Position = view.findViewById<TextView>(R.id.player1PosDisplay)
        val player2Position = view.findViewById<TextView>(R.id.player2PosDisplay)
        val player3Position = view.findViewById<TextView>(R.id.player3PosDisplay)


        var currentPlayer: Int = 1
        var player1Score: Int = 0
        var player2Score: Int = 0
        var player3Score: Int = 0

        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        player1Name = sharedPreferences.getString("Player 1", "")
        player2Name = sharedPreferences.getString("Player 2", "")
        player3Name = sharedPreferences.getString("Player 3", "")

        player1Text.text = player1Name
        player2Text.text = player2Name
        player3Text.text = player3Name


        val snakeHead = intArrayOf(11,27,41,44,69,78,88,91,98)
        val snakeTail = intArrayOf(7,3,17,39,31,56,51,68,89,29)
        val ladderTop = intArrayOf(29,36,48,59,75,86,89,95,99)
        val ladderBottom = intArrayOf(8,26,32,23,45,74,70,64,80)

        var player1Pos = 0
        var player2Pos = 0
        var player3Pos = 0



        rollBtn.setOnClickListener {

            val diceRoll = Random.nextInt(1, 7)

            if (currentPlayer == 1) {

                val turnString = "$player2Name turns"
                turnText.text = turnString


                player1Pos += diceRoll
                player1Score += diceRoll

                if(player1Score >= 100){
                    winnerDialog(player1Name.toString())

                    val sharedPreferences = requireActivity().getSharedPreferences("winners", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    val winnersJson = sharedPreferences.getString("winners", "[]") ?: "[]"
                    val winnersList = Gson().fromJson(winnersJson, object : TypeToken<MutableList<String>>() {}.type) as MutableList<String>
                    winnersList.add(player1Name.toString())

                    if (winnersList.size > 5) {
                        winnersList.removeAt(0)
                    }

                    val updatedWinnersJson = Gson().toJson(winnersList)
                    editor.putString("winners", updatedWinnersJson)
                    editor.apply()
                }

                val drawableResources = when (diceRoll) {
                    1 -> R.drawable.dice11
                    2 -> R.drawable.dice22
                    3 -> R.drawable.dice33
                    4 -> R.drawable.dice44
                    5 -> R.drawable.dice55
                    else -> R.drawable.dice66
                }
                diceImage.setImageResource(drawableResources)


                val boardSize = 10



                for (i in snakeHead.indices) {
                    if (player1Pos == snakeHead[i]) {
                        player1Pos = snakeTail[i]
                        player1Score = snakeTail[i]
                    }
                }

                for (i in ladderBottom.indices) {
                    if (player1Pos == ladderBottom[i]) {
                        player1Pos = ladderTop[i]
                        player1Score = ladderTop[i]
                    }
                }

                val rollString = "$player1Name rolled a $diceRoll. You are now in tile $player1Pos"
                rollText.text = rollString

                val player1ScoreString = "$player1Score"
                player1Position.text = player1ScoreString



                boardImage.post {

                    val boardWidth = boardImage.width
                    val boardHeight = boardImage.height

                    val direction = if ((player1Pos - 1) / 10 % 2 == 0) {
                        1
                    } else {
                        -1
                    }

                    val xPosition = if (direction == 1) {
                        ((player1Pos - 1) % boardSize) * boardWidth / boardSize
                    } else {
                        (boardSize - (player1Pos - 1) % boardSize - 1) * boardWidth / boardSize
                    }

                    val yPosition =
                        ((boardSize + 2) - (player1Pos - 1) / boardSize) * boardHeight / boardSize

                    player1Image.x = xPosition.toFloat()
                    player1Image.y = yPosition.toFloat()

                }
                currentPlayer = 2
            }
            else if(currentPlayer == 2)
            {

                val turnString = "$player3Name turns"
                turnText.text = turnString


                player2Pos += diceRoll
                player2Score += diceRoll

                if(player2Score >= 100){
                    winnerDialog(player2Name.toString())

                    val sharedPreferences = requireActivity().getSharedPreferences("winners", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    val winnersJson = sharedPreferences.getString("winners", "[]") ?: "[]"
                    val winnersList = Gson().fromJson(winnersJson, object : TypeToken<MutableList<String>>() {}.type) as MutableList<String>
                    winnersList.add(player2Name.toString())

                    if (winnersList.size > 5) {
                        winnersList.removeAt(0)
                    }

                    val updatedWinnersJson = Gson().toJson(winnersList)
                    editor.putString("winners", updatedWinnersJson)
                    editor.apply()

                }

                val drawableResources = when (diceRoll) {
                    1 -> R.drawable.dice11
                    2 -> R.drawable.dice22
                    3 -> R.drawable.dice33
                    4 -> R.drawable.dice44
                    5 -> R.drawable.dice55
                    else -> R.drawable.dice66
                }
                diceImage.setImageResource(drawableResources)


                val boardSize = 10



                for (i in snakeHead.indices) {
                    if (player2Pos == snakeHead[i]) {
                        player2Pos = snakeTail[i]
                        player2Score = snakeTail[i]
                    }
                }

                for (i in ladderBottom.indices) {
                    if (player2Pos == ladderBottom[i]) {
                        player2Pos = ladderTop[i]
                        player2Score = ladderTop[i]
                    }
                }

                val rollString = "$player2Name rolled a $diceRoll. You are now in tile $player2Pos"
                rollText.text = rollString

                val player2ScoreString = "$player2Score"
                player2Position.text = player2ScoreString




                boardImage.post {

                    val boardWidth = boardImage.width
                    val boardHeight = boardImage.height

                    val direction = if ((player2Pos - 1) / 10 % 2 == 0) {
                        1
                    } else {
                        -1
                    }

                    val xPosition = if (direction == 1) {
                        ((player2Pos - 1) % boardSize) * boardWidth / boardSize
                    } else {
                        (boardSize - (player2Pos - 1) % boardSize - 1) * boardWidth / boardSize
                    }

                    val yPosition =
                        ((boardSize + 2) - (player2Pos - 1) / boardSize) * boardHeight / boardSize

                    player2Image.x = xPosition.toFloat()
                    player2Image.y = yPosition.toFloat()

                }
                currentPlayer = 3

            }
            else
            {
                val turnString = "$player1Name turns"
                turnText.text = turnString


                player3Pos += diceRoll
                player3Score += diceRoll

                if(player3Score >= 100){
                    winnerDialog(player3Name.toString())

                    val sharedPreferences = requireActivity().getSharedPreferences("winners", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    val winnersJson = sharedPreferences.getString("winners", "[]") ?: "[]"
                    val winnersList = Gson().fromJson(winnersJson, object : TypeToken<MutableList<String>>() {}.type) as MutableList<String>
                    winnersList.add(player3Name.toString())

                    if (winnersList.size > 5) {
                        winnersList.removeAt(0)
                    }

                    val updatedWinnersJson = Gson().toJson(winnersList)
                    editor.putString("winners", updatedWinnersJson)
                    editor.apply()
                }

                val drawableResources = when (diceRoll) {
                    1 -> R.drawable.dice11
                    2 -> R.drawable.dice22
                    3 -> R.drawable.dice33
                    4 -> R.drawable.dice44
                    5 -> R.drawable.dice55
                    else -> R.drawable.dice66
                }
                diceImage.setImageResource(drawableResources)


                val boardSize = 10



                for (i in snakeHead.indices) {
                    if (player3Pos == snakeHead[i]) {
                        player3Pos = snakeTail[i]
                        player3Score = snakeTail[i]
                    }
                }

                for (i in ladderBottom.indices) {
                    if (player3Pos == ladderBottom[i]) {
                        player3Pos = ladderTop[i]
                        player3Score = ladderTop[i]
                    }
                }

                val rollString = "$player3Name rolled a $diceRoll. You are now in tile $player3Pos"
                rollText.text = rollString

                val player3ScoreString = "$player3Score"
                player3Position.text = player3ScoreString




                boardImage.post {

                    val boardWidth = boardImage.width
                    val boardHeight = boardImage.height

                    val direction = if ((player3Pos - 1) / 10 % 2 == 0) {
                        1
                    } else {
                        -1
                    }

                    val xPosition = if (direction == 1) {
                        ((player3Pos - 1) % boardSize) * boardWidth / boardSize
                    } else {
                        (boardSize - (player3Pos - 1) % boardSize - 1) * boardWidth / boardSize
                    }

                    val yPosition =
                        ((boardSize + 2) - (player3Pos - 1) / boardSize) * boardHeight / boardSize

                    player3Image.x = xPosition.toFloat()
                    player3Image.y = yPosition.toFloat()

                }
                currentPlayer = 1

            }


        }


        return view
    }

    private fun winnerDialog(winnerName: String){
        val alertDialog = AlertDialog.Builder(requireContext())
            .setTitle("GAME WINNER")
            .setMessage("$winnerName Wins!")
            .setPositiveButton(R.string.newGameButton) { _, _ ->
                startNewGame()
            }
            .setCancelable(false)
            .create()
        alertDialog.show()
    }



    private fun startNewGame(){
        val fragment = MainFragment()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
    }


}