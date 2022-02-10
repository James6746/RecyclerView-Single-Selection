package com.example.singleselectioninrecyclerview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context, val items: ArrayList<MyItem>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    companion object {
        var LASTCHANGEDPOSITION = -1
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val isChecked = view.findViewById<RelativeLayout>(R.id.background)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (items.get(position).isChecked == false) {
            holder.isChecked.setBackgroundColor(Color.RED)
        } else {
            holder.isChecked.setBackgroundColor(Color.GREEN)
        }

        holder.itemView.setOnClickListener {
            if (LASTCHANGEDPOSITION != -1) {
                select(holder, LASTCHANGEDPOSITION)
                notifyItemChanged(LASTCHANGEDPOSITION)
            }
            select(holder, position)
            LASTCHANGEDPOSITION = position
        }

    }

    private fun select(holder: MyViewHolder, position: Int) {
        if (items.get(position).isChecked) {
            items.get(position).isChecked = false
            holder.isChecked.setBackgroundColor(Color.RED)
        } else {
            items.get(position).isChecked = true
            holder.isChecked.setBackgroundColor(Color.GREEN)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}