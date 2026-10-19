package com.example.laba5


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerAdapter(
    context: Context,
    private val images: List<Image>
) : RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageView)
        val text: TextView = view.findViewById(R.id.textView)
        val description: TextView =
            view.findViewById(R.id.descriptionView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = inflater.inflate(
            R.layout.list_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = images[position]

        holder.text.text = item.name
        holder.description.text = item.description
        holder.image.setImageResource(item.imageRes)
    }

    override fun getItemCount(): Int = images.size
}
