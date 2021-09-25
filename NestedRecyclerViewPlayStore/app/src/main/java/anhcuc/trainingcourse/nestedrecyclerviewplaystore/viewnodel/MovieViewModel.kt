package anhcuc.trainingcourse.nestedrecyclerviewplaystore.viewnodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.Movies
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.MoviesResponse
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.repository.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private val _populars = MutableLiveData<MoviesResponse>()
    val populars: LiveData<MoviesResponse>
        get() = _populars

    private val _upcomings = MutableLiveData<MoviesResponse>()
    val upcomings: LiveData<MoviesResponse>
        get() = _upcomings

    private val _toprates = MutableLiveData<MoviesResponse>()
    val toprates: LiveData<MoviesResponse>
        get() = _toprates


    suspend fun getPopulars(): List<Movies> {
        val listPo = movieRepository.getPopularMovies()
        _populars.value = listPo
        return listPo.results
    }

    suspend fun getTops(): List<Movies> {
        val listTop = movieRepository.getTopRatedMovies()
        _populars.value = listTop
        return listTop.results
    }

    suspend fun getUpComings(): List<Movies> {
        val listUps = movieRepository.getUpcomingMovies()
        _populars.value = listUps
        return listUps.results
    }


}

class MovieViewModelFactory(private val movieRepository: MovieRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(movieRepository)
    }
}