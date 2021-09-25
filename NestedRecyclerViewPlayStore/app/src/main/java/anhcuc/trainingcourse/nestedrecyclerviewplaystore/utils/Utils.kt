package anhcuc.trainingcourse.nestedrecyclerviewplaystore.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.NonCancellable.start

object Utils {
    const val BASE_URL = "https://api.themoviedb.org/3/"
//    const val POPULAR_MOVIES_URL = "movie/popular"
//    const val TOP_RATED_MOVIES_URL = "movie/top_rated"
//    const val UP_COMING_MOVIES_URL = "movie/upcoming"
    const val API_KEY = "0a2806d321072b4b90999bd6049d66e9"
    const val URL_IMAGE = "https://image.tmdb.org/t/p/w500/"
}

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(url: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}