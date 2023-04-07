package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class Fragment2 : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_2, container, false)
        val toMainBtn2 : ImageButton = view.findViewById(R.id.backBtn1)
        val playGameBtn : ImageButton = view.findViewById(R.id.playgamebtn)
        val player1Name : EditText = view.findViewById(R.id.player1_field)
        val player2Name : EditText = view.findViewById(R.id.player2_field)
        val player3Name : EditText = view.findViewById(R.id.player3_field)

        playGameBtn.setOnClickListener(){

            val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("Player 1", player1Name.text.toString())
            editor.putString("Player 2", player2Name.text.toString())
            editor.putString("Player 3", player3Name.text.toString())
            editor.apply()

            val fragment = game3players()
            val bundle = Bundle()
            bundle.putString("Player 1", player1Name.text.toString())
            bundle.putString("Player 2", player2Name.text.toString())
            bundle.putString("Player 3", player3Name.text.toString())
            fragment.arguments = bundle

            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        toMainBtn2.setOnClickListener(){
            val fragment = MainFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        return view
    }


}