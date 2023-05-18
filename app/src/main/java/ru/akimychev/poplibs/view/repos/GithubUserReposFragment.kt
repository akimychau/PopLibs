package ru.akimychev.poplibs.view.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.akimychev.poplibs.App
import ru.akimychev.poplibs.core.BackPressedListener
import ru.akimychev.poplibs.core.UserDetailsOnItemClick
import ru.akimychev.poplibs.databinding.FragmentUserDetailsBinding
import ru.akimychev.poplibs.di.repos.ReposSubComponent
import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.model.entities.GithubUserRepos
import ru.akimychev.poplibs.presenter.GithubUserReposPresenter

class GithubUserReposFragment : MvpAppCompatFragment(), GithubUserReposView, BackPressedListener,
    UserDetailsOnItemClick {

    companion object {
        const val BUNDLE_GITHUB_USER = "BUNDLE_GITHUB_USER"
        fun getInstance(user: GithubUser): GithubUserReposFragment {
            return GithubUserReposFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(BUNDLE_GITHUB_USER, user)
                }
            }
        }
    }

    private lateinit var viewBinding: FragmentUserDetailsBinding
    private val adapter = GithubUserReposAdapter(this)
    private var reposSubComponent: ReposSubComponent? = null

    private val presenter: GithubUserReposPresenter by moxyPresenter {
        reposSubComponent = App.instance.initReposSubComponent()
        GithubUserReposPresenter().apply { reposSubComponent?.inject(this) }
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

    override fun initList(list: List<GithubUserRepos>, user: GithubUser) {
        adapter.githubUserReposList = list
        viewBinding.userAvatar.load(user.avatarUrl)
        viewBinding.userLogin.text = user.login
    }

    override fun release() {
        App.instance.releaseReposSubComponent()
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