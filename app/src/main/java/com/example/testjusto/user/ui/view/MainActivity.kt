package com.example.testjusto.user.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testjusto.R
import com.example.testjusto.background.result.Result
import com.example.testjusto.databinding.ActivityMainBinding
import com.example.testjusto.user.ui.fragment.UserFragment
import com.example.testjusto.user.ui.viewmodel.MainSharedViewModel
import com.example.testjusto.user.ui.viewmodel.MainSharedViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainSharedViewModel
    private lateinit var mBottomSheet: BottomSheetBehavior<CardView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this, MainSharedViewModelFactory()).get(MainSharedViewModel::class.java)

        mBinding.viewModel = mViewModel

        mBottomSheet = BottomSheetBehavior.from(mBinding.actMainBottomSheet)

        mViewModel.user.observe(this, {
            when (it.status) {
                Result.Status.LOADING -> {
                    mBottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
                }
                Result.Status.SUCCESS -> {
                    supportFragmentManager.beginTransaction().replace(mBinding.fragmentContainer.id, UserFragment.newInstance(), "UserFragment").commit()
                    mBottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
                }
                Result.Status.ERROR -> {
                    mBottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }
        })

    }
}