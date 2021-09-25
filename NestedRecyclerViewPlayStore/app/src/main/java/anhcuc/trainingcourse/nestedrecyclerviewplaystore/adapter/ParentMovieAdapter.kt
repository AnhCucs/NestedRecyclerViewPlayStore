package anhcuc.trainingcourse.nestedrecyclerviewplaystore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.R
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.Movies
import anhcuc.trainingcourse.nestedrecyclerviewplaystore.model.MoviesResponse

class ParentMovieAdapter(context: Context, private val dataList: List<MoviesResponse>) :
    RecyclerView.Adapter<ParentMovieAdapter.ItemRowHolder>() {
    private val mContext: Context = context

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemRowHolder {
        val v: View = LayoutInflater.from(mContext)
            .inflate(R.layout.layout_item_parent_movie, viewGroup, false)
        return ItemRowHolder(v)
    }

    override fun onBindViewHolder(itemRowHolder: ItemRowHolder, i: Int) {
        val sectionName: String = dataList[i].headTitle
        val singleSectionItems: List<Movies> = dataList[i].results
        val itemListDataAdapter = ChildMovieAdapter(singleSectionItems)

        itemRowHolder.apply {
            itemTitle.text = sectionName
            recyclerSection.setHasFixedSize(true)
            recyclerSection.layoutManager = LinearLayoutManager(
                mContext,
                LinearLayoutManager.HORIZONTAL, false
            )
            recyclerSection.adapter = itemListDataAdapter
            recyclerSection.isNestedScrollingEnabled = false
            btnMore.setOnClickListener { v ->
                Toast.makeText(
                    v.context, "click event on more, $sectionName",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ItemRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTitle: TextView = view.findViewById(R.id.itemTitle)
        var recyclerSection: RecyclerView = view.findViewById(R.id.rcvMovies)
        var btnMore: Button = view.findViewById(R.id.btnMore)
    }

}