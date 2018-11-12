package com.example.jonathansimonney.igeneration

import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.View
import kotlinx.android.synthetic.main.activity_news_detail.*


class ListAdapter// Provide a suitable constructor (depends on the kind of dataset)
(private val mDataset: List<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType != 0){
            val convertedHolder = holder as DefaultViewHolder
            convertedHolder.listText.text = mDataset[position - 1].title
        }
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class DefaultViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        var listText: TextView

        init {
            listText = v.findViewById(R.id.news_title)
        }
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class TitleViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        var listText: TextView

        init {
            listText = v.findViewById(R.id.big_title)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerView.ViewHolder {
        val layoutId :Int
        val ViewHolder :RecyclerView.ViewHolder
        if (viewType == 0){
            layoutId = R.layout.activity_news_title
            val v = LayoutInflater.from(parent.context)
                    .inflate(layoutId, parent, false)
            // set the view's size, margins, paddings and layout parameters
            return TitleViewHolder(v)
        }else{
            layoutId = R.layout.activity_news_detail
            val v = LayoutInflater.from(parent.context)
                    .inflate(layoutId, parent, false)
            // set the view's size, margins, paddings and layout parameters
            return DefaultViewHolder(v)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return mDataset.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0){
            return 0
        }
        return 1
    }
}