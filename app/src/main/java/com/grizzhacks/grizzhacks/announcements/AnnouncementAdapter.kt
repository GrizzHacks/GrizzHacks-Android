package com.grizzhacks.grizzhacks.announcements

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.grizzhacks.grizzhacks.R

/**
 * Displays a list of announcements in a RecyclerView
 */
class AnnouncementAdapter(var items: List<Announcement> = ArrayList()) : RecyclerView.Adapter<AnnouncementAdapter.AnnouncementViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AnnouncementViewHolder?, position: Int) {
        holder?.bindAnnouncement(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AnnouncementViewHolder {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_item_announcement, parent, false)
        return AnnouncementViewHolder(view)
    }

    class AnnouncementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val header = view.findViewById<TextView>(R.id.header) as TextView
        private val body = view.findViewById<TextView>(R.id.body) as TextView

        fun bindAnnouncement(item: Announcement) {
            header.text = item.header
            body.text = item.body
        }
    }
}