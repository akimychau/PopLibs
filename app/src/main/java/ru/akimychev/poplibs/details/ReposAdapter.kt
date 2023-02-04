package ru.akimychev.poplibs.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.akimychev.poplibs.R
import ru.akimychev.poplibs.databinding.ItemUserBinding
import ru.akimychev.poplibs.databinding.ReposUserBinding
import ru.akimychev.poplibs.details.OnItemClick
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.Repo

class ReposAdapter() :
    RecyclerView.Adapter<ReposAdapter.RepoViewHolder>() {

    var users: List<Repo> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ReposUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    inner class RepoViewHolder(
        private val binding: ReposUserBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Repo) = with(binding) {
            repos.text = item.name
        }
    }
}