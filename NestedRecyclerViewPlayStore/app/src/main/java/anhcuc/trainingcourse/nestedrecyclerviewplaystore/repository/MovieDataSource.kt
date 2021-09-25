package anhcuc.trainingcourse.nestedrecyclerviewplaystore.repository

import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.MoviesResponse
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.network.ApiService
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.utils.Utils


class MovieDataSource(private val apiService: ApiService) {

    suspend fun getUpcomingMovies(): MoviesResponse {
        return apiService.getUpcomingMovies(Utils.API_KEY)
    }

    suspend fun getTopRatedMovies(): MoviesResponse {
        return apiService.getTopRatedMovies(Utils.API_KEY)
    }

    suspend fun getPopularMovies(): MoviesResponse {
        return apiService.getPopularMovies(Utils.API_KEY)
    }

}