package anhcuc.trainingcourse.nestedrecyclerviewplaystore.repository

import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.MoviesResponse

class MovieRepository(private val dataSource: MovieDataSource) : IMovieRepository{
    override suspend fun getUpcomingMovies(): MoviesResponse {
        return dataSource.getUpcomingMovies()
    }

    override suspend fun getTopRatedMovies(): MoviesResponse {
        return dataSource.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): MoviesResponse {
        return dataSource.getPopularMovies()
    }
}