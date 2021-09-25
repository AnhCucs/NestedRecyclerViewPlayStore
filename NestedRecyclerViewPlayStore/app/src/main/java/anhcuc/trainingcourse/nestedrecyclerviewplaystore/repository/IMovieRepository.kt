package anhcuc.trainingcourse.nestedrecyclerviewplaystore.repository

import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.MoviesResponse

interface IMovieRepository {
    suspend fun getUpcomingMovies(): MoviesResponse
    suspend fun getTopRatedMovies(): MoviesResponse
    suspend fun getPopularMovies(): MoviesResponse
}