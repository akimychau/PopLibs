package ru.akimychev.poplibs.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.akimychev.poplibs.GeekBrainsApp
import ru.akimychev.poplibs.core.BackPressedListener
import ru.akimychev.poplibs.databinding.FragmentUserDetailsBinding
import ru.akimychev.poplibs.list.UserAdapter
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.Repo
import ru.akimychev.poplibs.network.NetworkProvider
import ru.akimychev.poplibs.repository.implApi.UserDetailsRepositoryImpl

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, BackPressedListener {

    companion object {
        const val BUNDLE_USER_LOGIN = "BUNDLE_USER_LOGIN"
        fun getInstance(login: String): UserDetailsFragment {
            return UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(BUNDLE_USER_LOGIN, login)
                }
            }
        }
    }

    private lateinit var viewBinding: FragmentUserDetailsBinding
    private val adapter = ReposAdapter()

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(
            GeekBrainsApp.instance.router,
            UserDetailsRepositoryImpl(NetworkProvider.usersApi, NetworkProvider.reposApi)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserDetailsBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(BUNDLE_USER_LOGIN)?.let { presenter.getLogin(it) }
        with(viewBinding) {
            reposList.layoutManager = LinearLayoutManager(requireContext())
            reposList.adapter = adapter
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun initList(list: List<Repo>) {
            adapter.users = list
        }

    override fun show(user: GithubUser) {
        viewBinding.userAvatar.load(user.userAvatar)
        viewBinding.userLogin.text = user.login
    }


    override fun showLoading() {
        viewBinding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        viewBinding.progressBar.visibility = View.GONE
    }
}