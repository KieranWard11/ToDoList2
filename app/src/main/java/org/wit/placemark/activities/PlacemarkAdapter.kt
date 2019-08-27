package org.wit.placemark;

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_task.view.*
import org.wit.placemark.helpers.readImageFromPath
import org.wit.placemark.models.PlacemarkModel

interface PlacemarkListener {
    fun onPlacemarkClick(placemark: PlacemarkModel)

    fun onCompleteClick(placemark: PlacemarkModel)
}


class PlacemarkAdapter constructor(private var placemarks: List<PlacemarkModel>, private val listener: PlacemarkListener) : RecyclerView.Adapter<PlacemarkAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_task, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val placemark = placemarks[holder.adapterPosition]
        holder.bind(placemark, listener)
    }

    override fun getItemCount(): Int = placemarks.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(placemark: PlacemarkModel,  listener : PlacemarkListener) {
            itemView.title.text = placemark.title
            itemView.description.text = placemark.description
            itemView.priority.text = placemark.priority
            itemView.imageIcon.setImageBitmap(readImageFromPath(itemView.context, placemark.image))
            itemView.checkBox.setOnClickListener { listener.onCompleteClick(placemark) }
            itemView.setOnClickListener { listener.onPlacemarkClick(placemark) }
        }
    }
}