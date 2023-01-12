package ru.akimychev.poplibs.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.akimychev.poplibs.R
import ru.akimychev.poplibs.details.OnItemClick
import ru.akimychev.poplibs.model.GithubUser

class UserAdapter(private val callback: OnItemClick) :
    RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return GithubUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    inner class GithubUserViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val tvLogin by lazy { itemView.findViewById<TextView>(R.id.userLogin) }

        fun bind(item: GithubUser) {
            tvLogin.text = item.login
            tvLogin.setOnClickListener {
                callback.onItemClick(item)
            }
        }
    }
}