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
import ru.akimychev.poplibs.repository.impl.UserDetailsRepositoryImpl

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, BackPressedListener {

    companion object {
        fun getInstance(): UserDetailsFragment {
            return UserDetailsFragment()
        }
    }

    private lateinit var viewBinding: FragmentUserDetailsBinding

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(UserDetailsRepositoryImpl(), GeekBrainsApp.instance.router)
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
        presenter.loginClick()
    }

    override fun onBackPressed() = presenter.onBackPressed()


    override fun initLogin(login: String) {
        viewBinding.userLogin.text = login
    }
}