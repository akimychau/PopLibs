package ru.akimychev.poplibs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.akimychev.poplibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnBoom.setOnClickListener {
                presenter.onCounterClick(R.id.btnBoom)
            }
            btnBoom1.setOnClickListener {
                presenter.onCounterClick(R.id.btnBoom1)
            }
            btnBoom2.setOnClickListener {
                presenter.onCounterClick(R.id.btnBoom2)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                0 -> tvText.text = counter
                1 -> tvText1.text = counter
                2 -> tvText2.text = counter
            }
        }
    }
}