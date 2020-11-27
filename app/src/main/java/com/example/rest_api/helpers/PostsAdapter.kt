package com.example.rest_api.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rest_api.R
import com.example.rest_api.models.Post

class PostsAdapter (private val postsList: List<Post>): RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: PostsAdapter.ViewHolder, position: Int) {
        Log.d("Response", "List Count :${postsList.size} ")
        return holder.bind(postsList[position])
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var userId = itemView.findViewById<TextView>(R.id.userId)
        var id = itemView.findViewById<TextView>(R.id.id)
        var title = itemView.findViewById<TextView>(R.id.title)
        var body = itemView.findViewById<TextView>(R.id.body)

        fun bind(post: Post) {
            userId = userId;
            id = id
            title.text = title.toString()
            body.text = body.toString()
        }

    }

}