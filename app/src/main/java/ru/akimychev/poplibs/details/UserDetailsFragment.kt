package ru.akimychev.poplibs.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.akimychev.poplibs.GeekBrainsApp
import ru.akimychev.poplibs.core.BackPressedListener
import ru.akimychev.poplibs.databinding.FragmentUserDetailsBinding

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, BackPressedListener {

    companion object {
        const val BUNDLE_EXTRA_WEATHER = "BUNDLE_EXTRA_WEATHER"
        fun getInstance(login: String): UserDetailsFragment {
            val bundle = Bundle()
            bundle.putString(BUNDLE_EXTRA_WEATHER, login)
            val fragment = UserDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewBinding: FragmentUserDetailsBinding

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(GeekBrainsApp.instance.router)
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

        val login = arguments?.getString(BUNDLE_EXTRA_WEATHER)
        login?.let { presenter.getLogin(it) }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun initLogin(login: String) {
        viewBinding.userLogin.text = login
    }
}