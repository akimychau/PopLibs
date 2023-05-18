package ru.akimychev.poplibs.view.forkscount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.akimychev.poplibs.App
import ru.akimychev.poplibs.core.BackPressedListener
import ru.akimychev.poplibs.databinding.FragmentForksCountBinding
import ru.akimychev.poplibs.di.repos.ReposSubComponent
import ru.akimychev.poplibs.model.entities.GithubUserRepos
import ru.akimychev.poplibs.presenter.ForksCountPresenter

class ForksCountFragment : MvpAppCompatFragment(), ForksCountView, BackPressedListener {

    companion object {
        const val BUNDLE_FORKS_COUNT = "BUNDLE_FORKS_COUNT"
        fun getInstance(repos: GithubUserRepos): ForksCountFragment {
            return ForksCountFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(BUNDLE_FORKS_COUNT, repos)
                }
            }
        }
    }

    private lateinit var viewBinding: FragmentForksCountBinding
    private var reposSubComponent: ReposSubComponent? = null

    private val presenter: ForksCountPresenter by moxyPresenter {
        reposSubComponent = App.instance.initReposSubComponent()
        ForksCountPresenter().apply {
            reposSubComponent?.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentForksCountBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<GithubUserRepos>(BUNDLE_FORKS_COUNT)
            ?.let { presenter.show(it) }
    }

    override fun onBackPressed(): Boolean {
        presenter.onBackPressed()
        return true
    }

    override fun showNumberOfForks(forks: String) {
        viewBinding.forksCount.text = forks
    }
}
