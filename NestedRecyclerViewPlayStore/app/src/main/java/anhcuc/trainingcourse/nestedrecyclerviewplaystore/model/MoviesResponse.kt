package anhcuc.trainingcourse.nestedrecyclerviewplaystore.model

import com.google.gson.annotations.SerializedName


data class MoviesResponse(
    val headTitle: String,
    val page: Int,
    val results: List<Movies>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)