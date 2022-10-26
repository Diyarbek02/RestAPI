package com.diyarbek.restapi.model

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyarbek.restapi.R

class SchoolClassAdapter : RecyclerView.Adapter<SchoolClassAdapter.SchoolClassViewHolder>() {

    var models: List<SchoolClass>? = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class SchoolClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: SchoolClass?) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolClassViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_school_class, parent, false)
        return SchoolClassViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SchoolClassViewHolder, position: Int) {
        holder.populateModel(models?.get(position))
    }

    override fun getItemCount(): Int = models!!.size
}