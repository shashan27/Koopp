package io.deanencoded.koopp.post

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.deanencoded.koopp.R
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter : PagingDataAdapter<resultData, MyAdapter.ViewHolder>(DiffUtilCallBack()){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val user_id: TextView = itemView.findViewById(R.id.user_id_tv)
        val title: TextView = itemView.findViewById(R.id.title_tv)
        val body: TextView = itemView.findViewById(R.id.body_tv)
        val id: TextView = itemView.findViewById(R.id.id_tv)

        fun bind(data: resultData){
            user_id.text = data.user_id.toString()
            title.text = data.title
            body.text = data.body
            id.text = data.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }


    class DiffUtilCallBack : DiffUtil.ItemCallback<resultData>(){
        override fun areItemsTheSame(oldItem: resultData, newItem: resultData): Boolean {
            return oldItem.user_id == newItem.user_id
        }

        override fun areContentsTheSame(oldItem: resultData, newItem: resultData): Boolean {
            return oldItem.user_id == newItem.user_id
                    && oldItem.title == newItem.title
                    && oldItem.body == newItem.body
                    && oldItem.id == newItem.id
        }

    }
}