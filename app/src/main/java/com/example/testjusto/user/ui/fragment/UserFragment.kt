package com.example.testjusto.user.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testjusto.R
import com.example.testjusto.databinding.FragmentUserBinding
import com.example.testjusto.user.ui.viewmodel.MainSharedViewModel

class UserFragment : Fragment() {

    private lateinit var mBinding: FragmentUserBinding
    private lateinit var mViewModel: MainSharedViewModel

    companion object {
        fun newInstance(): UserFragment {
            val args = Bundle()

            val fragment = UserFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mViewModel = ViewModelProvider(requireActivity()).get(MainSharedViewModel::class.java)
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        mBinding.viewModel = mViewModel

        return mBinding.root
    }
}