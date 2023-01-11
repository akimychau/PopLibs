package ru.akimychev.poplibs.user

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
import ru.akimychev.poplibs.main.UserAdapter
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.repository.impl.GithubRepositoryImpl

class UserFragment : MvpAppCompatFragment(), UserView, BackPressedListener {

    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    private lateinit var viewBinding: FragmentUserListBinding

    private val adapter = UserAdapter()
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), GeekBrainsApp.instance.router)
    }

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
}