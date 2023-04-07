package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val to2Player: Button = view.findViewById(R.id.Btn1)
        val to3Player: Button = view.findViewById(R.id.Btn2)
        val to4Player: Button = view.findViewById(R.id.Btn3)
        val toExit: Button = view.findViewById(R.id.Btn4)

        to2Player.setOnClickListener(){
            val fragment = Fragment1()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        to3Player.setOnClickListener(){
            val fragment = Fragment2()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        to4Player.setOnClickListener(){
            val fragment = player4()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        toExit.setOnClickListener(){
            System.exit(1);
        }

        return view
    }


}