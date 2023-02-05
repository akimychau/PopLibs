package ru.akimychev.poplibs.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.akimychev.poplibs.databinding.ItemReposBinding
import ru.akimychev.poplibs.model.UserRepos

class UserDetailsAdapter :
    RecyclerView.Adapter<UserDetailsAdapter.ReposListViewHolder>() {

    var userReposList: List<UserRepos> = emptyList()
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
        holder.bind(userReposList[position])
    }

    override fun getItemCount() = userReposList.size

    inner class ReposListViewHolder(
        private val binding: ItemReposBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserRepos) = with(binding) {
            reposName.text = item.name
        }
    }
}