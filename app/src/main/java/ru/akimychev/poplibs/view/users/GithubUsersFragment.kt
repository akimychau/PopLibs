package ru.akimychev.poplibs.view.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.akimychev.poplibs.App
import ru.akimychev.poplibs.core.BackPressedListener
import ru.akimychev.poplibs.core.UserListOnItemClick
import ru.akimychev.poplibs.databinding.FragmentUserListBinding
import ru.akimychev.poplibs.di.user.UserSubComponent
import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.presenter.GithubUsersPresenter

class GithubUsersFragment : MvpAppCompatFragment(), GithubUsersView, BackPressedListener,
    UserListOnItemClick {

    companion object {
        fun getInstance(): GithubUsersFragment {
            return GithubUsersFragment()
        }
    }

    private lateinit var viewBinding: FragmentUserListBinding
    private val adapter = GithubUsersAdapter(this)
    private var userSubComponent: UserSubComponent? = null

    private val presenter: GithubUsersPresenter by moxyPresenter {
        userSubComponent = App.instance.initUserSubComponent()
        GithubUsersPresenter().apply {
            userSubComponent?.inject(this)
        }
    }

    lateinit var res: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
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

    override fun showLoading() {
        viewBinding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        viewBinding.progressBar.visibility = View.GONE
    }

    override fun release() {
        App.instance.releaseUserSubComponent()
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun userListOnItemClick(user: GithubUser) {
        presenter.navigateToDetails(user)
    }
}