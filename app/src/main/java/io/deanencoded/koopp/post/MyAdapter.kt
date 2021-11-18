package io.deanencoded.koopp.post

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.deanencoded.koopp.R
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter(val context: Context, val userList: List<Data>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userId: TextView
        var title: TextView
        var body: TextView
        var id: TextView

        init {
            userId = itemView.user_id_tv
            title = itemView.title_tv
            body = itemView.body_tv
            id = itemView.id_tv
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = userList[position].userId.toString()
        holder.title.text = userList[position].title
        holder.body.text = userList[position].body
        holder.id.text = userList[position].id.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}