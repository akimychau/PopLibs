package ru.akimychev.poplibs.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.akimychev.poplibs.core.UserDetailsOnItemClick
import ru.akimychev.poplibs.databinding.ItemReposBinding
import ru.akimychev.poplibs.model.GithubUserRepos

class GithubUserReposAdapter(private val callback: UserDetailsOnItemClick) :
    RecyclerView.Adapter<GithubUserReposAdapter.ReposListViewHolder>() {

    var githubUserReposList: List<GithubUserRepos> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposListViewHolder {
        val binding = ItemReposBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReposListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReposListViewHolder, position: Int) {
        holder.bind(githubUserReposList[position])
    }

    override fun getItemCount() = githubUserReposList.size

    inner class ReposListViewHolder(
        private val binding: ItemReposBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GithubUserRepos) = with(binding) {
            reposName.text = item.name
            card.setOnClickListener {
                callback.userDetailsOnItemClick(item)
            }
        }
    }
}