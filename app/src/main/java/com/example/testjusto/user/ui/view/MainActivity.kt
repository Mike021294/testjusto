package com.example.testjusto.user.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testjusto.R
import com.example.testjusto.databinding.ActivityMainBinding
import com.example.testjusto.user.ui.viewmodel.MainSharedViewModel
import com.example.testjusto.user.ui.viewmodel.MainSharedViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mViewModel = ViewModelProvider(this, MainSharedViewModelFactory()).get(MainSharedViewModel::class.java)

        mViewModel.getRandomUser()
    }
}