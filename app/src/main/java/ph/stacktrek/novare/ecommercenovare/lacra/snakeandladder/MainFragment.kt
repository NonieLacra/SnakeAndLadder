package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater)
        val view = binding.root



        binding.fragment1Btn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_fragment1)
        }

        binding.fragment2Btn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_fragment2)
        }


    }
}