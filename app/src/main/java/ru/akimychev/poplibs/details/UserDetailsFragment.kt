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
import ru.akimychev.poplibs.cache.RoomRepositoriesCache
import ru.akimychev.poplibs.core.BackPressedListener
import ru.akimychev.poplibs.core.UserDetailsOnItemClick
import ru.akimychev.poplibs.core.connectivityListener.ConnectivityListener
import ru.akimychev.poplibs.database.GithubAppDb
import ru.akimychev.poplibs.databinding.FragmentUserDetailsBinding
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos
import ru.akimychev.poplibs.network.NetworkProvider
import ru.akimychev.poplibs.repository.implApi.UserDetailsRepositoryImpl

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, BackPressedListener,
    UserDetailsOnItemClick {

    companion object {
        const val BUNDLE_GITHUB_USER = "BUNDLE_GITHUB_USER"
        fun getInstance(user: GithubUser): UserDetailsFragment {
            return UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(BUNDLE_GITHUB_USER, user)
                }
            }
        }
    }

    private lateinit var viewBinding: FragmentUserDetailsBinding
    private val adapter = UserDetailsAdapter(this)

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(
            GeekBrainsApp.instance.router,
            UserDetailsRepositoryImpl(NetworkProvider.githubUserReposApi,
                ConnectivityListener(GeekBrainsApp.instance),
                RoomRepositoriesCache(GithubAppDb.getInstance()))
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentUserDetailsBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<GithubUser>(BUNDLE_GITHUB_USER)?.let { presenter.getLogin(it) }
        with(viewBinding) {
            reposList.layoutManager = LinearLayoutManager(requireContext())
            reposList.adapter = adapter
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun initList(list: List<GithubUserRepos>) {
        adapter.githubUserReposList = list
    }

    override fun show(user: GithubUser) {
        viewBinding.userAvatar.load(user.avatarUrl)
        viewBinding.userLogin.text = user.login
    }


    override fun showLoading() {
        viewBinding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        viewBinding.progressBar.visibility = View.GONE
    }

    override fun userDetailsOnItemClick(repos: GithubUserRepos) {
        presenter.navigateToDetails(repos)
    }
}