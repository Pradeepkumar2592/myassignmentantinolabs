package com.example.myassignmentantinolabs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignmentantinolabs.R
import com.example.myassignmentantinolabs.model.Destination
import com.squareup.picasso.Picasso

class DestinationAdapter(private val destinationList: List<Destination>) : RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.destination = destinationList[position]
        holder.txvName.text = destinationList[position].name
        holder.txvAge.text = destinationList[position].age
        holder.txvLocation.text = destinationList[position].location
        Picasso.get()// give it the context
            .load(destinationList[position].url) // load the image
            .into(holder.imgIcon) // select the ImageView to load it into



    }

    override fun getItemCount(): Int {
        return destinationList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txvName: TextView = itemView.findViewById(R.id.txtName)
        val txvAge:TextView = itemView.findViewById(R.id.txtAge)
        val txvLocation:TextView = itemView.findViewById(R.id.txtLocation)
        val imgIcon:ImageView = itemView.findViewById(R.id.icon)
        var destination: Destination? = null

        override fun toString(): String {
            return """${super.toString()} '${txvName.text}'"""
        }
    }
}
