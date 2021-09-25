package anhcuc.trainingcourse.nestedrecyclerviewplaystore

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.adapter.ParentMovieAdapter
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.Movies
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.MoviesResponse
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.network.RetrofitInstance
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.repository.MovieDataSource
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.repository.MovieRepository
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.viewnodel.MovieViewModel
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.viewnodel.MovieViewModelFactory
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private val viewModel: MovieViewModel by viewModels {
        MovieViewModelFactory(
            MovieRepository(
                MovieDataSource(
                    RetrofitInstance.apiService
                )
            )
        )
    }
    private var allSampleData: ArrayList<MoviesResponse> = ArrayList()
    lateinit var sectionRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        showData()
    }

    private fun showData() {
        val sectionAdapter = ParentMovieAdapter(this, allSampleData)
        sectionRecyclerView = findViewById(R.id.rcvMain)

        sectionRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = sectionAdapter
        }
    }

    private fun initData() = runBlocking {

        val titleOne = "Popular"
        val titleTwo = "Top Rated"
        val titleThree = "Up Coming"

        val listPo = viewModel.getPopulars()
        val listTop = viewModel.getTops()
        val listRate = viewModel.getUpComings()

        allSampleData.add(MoviesResponse(titleOne,1,listPo,1,1))
        allSampleData.add(MoviesResponse(titleTwo,1,listTop,1,1))
        allSampleData.add(MoviesResponse(titleThree,1,listRate,1,1))
    }
}