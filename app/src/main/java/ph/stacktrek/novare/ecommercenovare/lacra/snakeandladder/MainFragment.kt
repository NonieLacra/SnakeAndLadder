package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val to2Player: Button = view.findViewById(R.id.TwoPlayerBtn)
        val to3Player: Button = view.findViewById(R.id.ThreePlayerBtn)
        val to4Player: Button = view.findViewById(R.id.FourPlayerBtn)
        val toExit: Button = view.findViewById(R.id.ExitBtn)
        val toWinnerslist: ImageButton = view.findViewById(R.id.WinnersList)

        to2Player.setOnClickListener(){
            val fragment = TwoPlayerMenu()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        to3Player.setOnClickListener(){
            val fragment = ThreePlayerMenu()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        to4Player.setOnClickListener(){
            val fragment = FourPlayerMenu()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        toExit.setOnClickListener(){
            System.exit(1);
        }

        toWinnerslist.setOnClickListener(){
            val fragment = Winnerslist()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        return view
    }


}