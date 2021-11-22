package io.deanencoded.koopp.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shashank.koopp.post.ResultData
import io.deanencoded.koopp.R

class MyAdapter : PagingDataAdapter<ResultData, MyAdapter.ViewHolder>(DiffUtilCallBack()){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val user_id: TextView = itemView.findViewById(R.id.user_id_tv)
        private val title: TextView = itemView.findViewById(R.id.title_tv)
        private val body: TextView = itemView.findViewById(R.id.body_tv)
        private val id: TextView = itemView.findViewById(R.id.id_tv)

        fun bind(data: ResultData){
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


    class DiffUtilCallBack : DiffUtil.ItemCallback<ResultData>(){
        override fun areItemsTheSame(oldItem: ResultData, newItem: ResultData): Boolean {
            return oldItem.user_id == newItem.user_id
        }

        override fun areContentsTheSame(oldItem: ResultData, newItem: ResultData): Boolean {
            return oldItem.user_id == newItem.user_id
                    && oldItem.title == newItem.title
                    && oldItem.body == newItem.body
                    && oldItem.id == newItem.id
        }

    }
}