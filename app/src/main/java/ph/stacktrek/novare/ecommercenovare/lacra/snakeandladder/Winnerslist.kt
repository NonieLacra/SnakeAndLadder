package ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ph.stacktrek.novare.ecommercenovare.lacra.snakeandladder.databinding.FragmentWinnerslistBinding


class Winnerslist : Fragment() {

    private var _binding: FragmentWinnerslistBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWinnerslistBinding.inflate(inflater, container, false)


        binding.backButton.setOnClickListener(){
            val fragment = MainFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val winners = fetchWinners()
        val adapter = WinnersAdapter(winners)
        binding.winnersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.winnersRecyclerView.adapter = adapter

    }

    private fun fetchWinners(): List<String> {
        val sharedPreferences = requireActivity().getSharedPreferences("winners", Context.MODE_PRIVATE)
        val winnersJson = sharedPreferences.getString("winners", "[]") ?: "[]"
        val winnersList = Gson().fromJson(winnersJson, object : TypeToken<List<String>>() {}.type) as MutableList<String>

        // Return the latest 5 winners
        return if (winnersList.size > 5) {
            winnersList.takeLast(5)
        } else {
            winnersList
        }
    }


}