package ru.akimychev.poplibs.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.akimychev.poplibs.R
import ru.akimychev.poplibs.databinding.ItemUserBinding
import ru.akimychev.poplibs.core.UserListOnItemClick
import ru.akimychev.poplibs.model.GithubUser

class UserListAdapter(private val callback: UserListOnItemClick) :
    RecyclerView.Adapter<UserListAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    inner class GithubUserViewHolder(
        private val binding: ItemUserBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GithubUser) = with(binding) {
            userLogin.text = item.login
            card.setOnClickListener {
                callback.userListOnItemClick(item)
            }
            userAvatar.load(item.userAvatar) {
                placeholder(R.drawable.ic_baseline_supervised_user_circle_24)
            }
        }
    }
}