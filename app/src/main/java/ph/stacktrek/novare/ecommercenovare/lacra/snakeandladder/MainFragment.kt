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
        val toFrag1Btn: Button = view.findViewById(R.id.Btn1)
        val toFrag2Btn: Button = view.findViewById(R.id.Btn2)
        val toFrag3Btn: Button = view.findViewById(R.id.Btn3)

        toFrag1Btn.setOnClickListener(){
            val fragment = Fragment1()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        toFrag2Btn.setOnClickListener(){
            val fragment = Fragment2()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        toFrag3Btn.setOnClickListener(){
            System.exit(1);
        }

        return view
    }


}