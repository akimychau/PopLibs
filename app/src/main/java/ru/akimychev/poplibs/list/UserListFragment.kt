package ru.akimychev.poplibs.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.akimychev.poplibs.GeekBrainsApp
import ru.akimychev.poplibs.core.BackPressedListener
import ru.akimychev.poplibs.databinding.FragmentUserListBinding
import ru.akimychev.poplibs.details.OnItemClick
import ru.akimychev.poplibs.main.UserAdapter
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.repository.impl.UserListRepositoryImpl

class UserListFragment : MvpAppCompatFragment(), UserListView, BackPressedListener, OnItemClick {

    companion object {
        fun getInstance(): UserListFragment {
            return UserListFragment()
        }
    }

    private lateinit var viewBinding: FragmentUserListBinding

    private val adapter = UserAdapter(this)
    private val presenter: UserListPresenter by moxyPresenter {
        UserListPresenter(UserListRepositoryImpl(), GeekBrainsApp.instance.router)
    }

    lateinit var res: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun onItemClick(login: GithubUser) {
        presenter.navigateToDetails()
    }

}