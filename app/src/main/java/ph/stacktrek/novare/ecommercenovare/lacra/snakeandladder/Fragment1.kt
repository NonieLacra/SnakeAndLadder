package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val toMainBtn1 : Button = view.findViewById(R.id.backBtn1)
        val playGameBtn : Button = view.findViewById(R.id.playgamebtn)

        playGameBtn.setOnClickListener{
            val fragment = Fragment3()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()


        }



        toMainBtn1.setOnClickListener(){
            val fragment = MainFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }

        return view
    }
}