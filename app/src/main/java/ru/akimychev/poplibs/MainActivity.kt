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
                presenter.onCounterClick(0)
            }
            btnBoomOne.setOnClickListener {
                presenter.onCounterClick(1)
            }
            btnBoomTwo.setOnClickListener {
                presenter.onCounterClick(2)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setTextForBoom(counter: String) {
        binding.tvText.text = counter
    }

    override fun setTextForBoomOne(counter: String) {
        binding.tvText1.text = counter
    }

    override fun setTextForBoomTwo(counter: String) {
        binding.tvText2.text = counter
    }
}