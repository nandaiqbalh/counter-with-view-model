package com.nandaiqbalh.counterwithviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nandaiqbalh.counterwithviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var mCounter: Int = 0

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // without view model
//        withoutViewModel()

        // with view model
        withViewModel()
    }

    private fun withViewModel(){
        binding.btnPlus.setOnClickListener {
            wIncrementCount()
        }

        binding.btnMinus.setOnClickListener {
            wDecrementCount()
        }

        viewModel.vCounter.observe(this){ result ->
            binding.tvCount.text = result.toString()
        }
    }

    private fun wIncrementCount(){
        viewModel.incrementCount()
    }

    private fun wDecrementCount(){
        viewModel.decrementCount()
    }

    private fun withoutViewModel(){
        binding.btnPlus.setOnClickListener {
            mIncrementCount()
        }

        binding.btnMinus.setOnClickListener {
            mDecrementCount()
            updateUI()
        }
    }

    private fun mIncrementCount(){
        mCounter += 1
        updateUI()
    }

    private fun mDecrementCount(){
        mCounter.let {
            if (it > 0) mCounter -= 1
        }
    }

    private fun updateUI(){
        binding.tvCount.text = mCounter.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}