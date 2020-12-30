package com.rolandoasmat.count

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as? CountsApplication)?.component()?.inject(this)

        viewModel.count.observe(this) { countInt ->
            countLabel?.text = countInt.toString()
        }

        increaseButton.setOnClickListener {
            viewModel.incrementButtonPressed()
        }

        decreaseButton.setOnClickListener {
            viewModel.decrementButtonPressed()
        }

        resetButton.setOnClickListener {
            viewModel.resetButtonPressed()
        }
    }
}