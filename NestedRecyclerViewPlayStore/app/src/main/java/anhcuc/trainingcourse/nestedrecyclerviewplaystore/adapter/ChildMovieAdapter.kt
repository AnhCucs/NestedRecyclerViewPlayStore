package anhcuc.trainingcourse.nestedrecyclerviewplaystore.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.R
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.Movies
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.utils.Utils.URL_IMAGE
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.utils.getProgressDrawable
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.utils.loadImage

class ChildMovieAdapter(private val itemsList: List<Movies>) :
    RecyclerView.Adapter<ChildMovieAdapter.SingleItemRowHolder>() {

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SingleItemRowHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_movie, null)
        return SingleItemRowHolder(view)
    }

    override fun onBindViewHolder(holder: SingleItemRowHolder, i: Int) {
        val singleItem: Movies = itemsList[i]
        holder.bind(singleItem)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    inner class SingleItemRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgPoster: ImageView = view.findViewById(R.id.imgPoster)
        var imgFavorite: ImageView = view.findViewById(R.id.imgFavorite)
        var txtTitleMovie: TextView = view.findViewById(R.id.txtTitleMovie)
        var txtDuration: TextView = view.findViewById(R.id.txtDurationMovie)
        private var layout: View = view

        private val progressDrawable = getProgressDrawable(itemView.context)
        fun bind(movies: Movies) {
            layout.setOnClickListener { v ->
                Toast.makeText(v.context, movies.title, Toast.LENGTH_SHORT).show()
            }
            imgPoster.loadImage(
                "${URL_IMAGE}${movies.posterPath}",
                progressDrawable
            )
            txtTitleMovie.text = movies.title
            txtDuration.text = movies.popularity.toString()
        }
    }

}