package com.pissiphany.ports.ui.posts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.pissiphany.ports.domain.model.Post
import com.pissiphany.ports.ui.R

/**
 * Created by kierse on 2016-08-13.
 */
class PostListAdapter(context : Context, layout : Int) : ArrayAdapter<Post>(context, layout) {
    private data class ViewHolder(val id: TextView, val title: TextView, val body: TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val post = getItem(position)

        var view = convertView
        var holder : ViewHolder
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.activity_post_list_item, parent, false
            )

            holder = ViewHolder(
                    view.findViewById(R.id.id) as TextView,
                    view.findViewById(R.id.title) as TextView,
                    view.findViewById(R.id.body) as TextView
            )
            view.setTag(holder)
        } else {
            holder = view.getTag() as ViewHolder
        }

        holder.id.text = post.id.toString()
        holder.title.text = post.title
        holder.body.text = post.body

        return view
    }
}
