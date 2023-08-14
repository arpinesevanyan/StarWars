package com.arpinesevanyan.starwars
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.arpinesevanyan.starwars.adapters.PagerAdapter
import com.arpinesevanyan.starwars.model.MainViewModel
import com.arpinesevanyan.starwars.model.MainViewModelFactory
import com.arpinesevanyan.starwars.repo.ApiService
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = ApiService.api
        viewModel = ViewModelProvider(this, MainViewModelFactory(apiService))
            .get(MainViewModel::class.java)

        val searchEditText: EditText = findViewById(R.id.searchEditText)
        val searchButton: Button = findViewById(R.id.searchButton)

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            viewModel.searchCharacters(query)
            viewModel.searchStarships(query)
        }

        val characterFragment = CharacterFragment()
        val starshipFragment = StarshipFragment()

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val fragmentList = listOf(characterFragment, starshipFragment)
        val pagerAdapter = PagerAdapter(this, fragmentList)
        viewPager.adapter = pagerAdapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Characters"
                else -> "Starships"
            }
        }.attach()
    }
}



