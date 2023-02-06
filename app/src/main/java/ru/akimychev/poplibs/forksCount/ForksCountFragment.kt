package ru.akimychev.poplibs.forksCount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.akimychev.poplibs.GeekBrainsApp
import ru.akimychev.poplibs.core.BackPressedListener
import ru.akimychev.poplibs.databinding.FragmentForksCountBinding
import ru.akimychev.poplibs.model.UserRepos

class ForksCountFragment : MvpAppCompatFragment(), ForksCountView, BackPressedListener {

    companion object {
        const val BUNDLE_FORKS_COUNT = "BUNDLE_FORKS_COUNT"
        fun getInstance(repos: UserRepos): ForksCountFragment {
            return ForksCountFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(BUNDLE_FORKS_COUNT, repos)
                }
            }
        }
    }

    private lateinit var viewBinding: FragmentForksCountBinding

    private val presenter: ForksCountPresenter by moxyPresenter { ForksCountPresenter(GeekBrainsApp.instance.router) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentForksCountBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<UserRepos>(BUNDLE_FORKS_COUNT)
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
