package com.arpinesevanyan.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.starwars.adapters.StarshipAdapter
import com.arpinesevanyan.starwars.data.Starship
import com.arpinesevanyan.starwars.model.MainViewModel

class StarshipFragment : Fragment(), StarshipAdapter.StarshipClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var starshipAdapter: StarshipAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_starship, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        starshipAdapter = StarshipAdapter(this)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = starshipAdapter
        }

        viewModel.starships.observe(viewLifecycleOwner, { starships ->
            starshipAdapter.setStarships(starships)
            starshipAdapter.notifyDataSetChanged()
        })

        return view
    }

    override fun onStarshipClick(starship: Starship) {
        // Обработка нажатия на звездолет
    }
}


