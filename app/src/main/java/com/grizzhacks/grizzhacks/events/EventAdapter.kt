package com.grizzhacks.grizzhacks.events

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.grizzhacks.grizzhacks.R

/**
 * Displays a list of announcements in a RecyclerView
 */
class EventAdapter(var items: List<Event> = ArrayList()) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: EventViewHolder?, position: Int) {
        holder?.bindEvent(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EventViewHolder {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_item_event, parent, false)
        return EventViewHolder(view)
    }

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.title) as TextView

        fun bindEvent(item: Event) {
            title.text = item.title
        }
    }
}