package com.codejunior.paytoqr.view.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.codejunior.paytoqr.R
import com.codejunior.paytoqr.databinding.RegisterFragmentBinding
import com.codejunior.paytoqr.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {

    companion object {
        fun newInstanceRegister() = RegisterFragment()

    }



    private lateinit var viewModel: RegisterViewModel
    private var _binding:RegisterFragmentBinding? = null
    private val binding  get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("RegisterFragment.onCreate")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater,R.layout.register_fragment,container,false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        println("RegisterFragment.onActivityCreated")
        // TODO: Use the ViewModel
    }

    override fun onPause() {
        super.onPause()
        println("RegisterFragment.onPause")
    }

    override fun onStop() {
        super.onStop()
        println("RegisterFragment.onStop")
    }

    override fun onResume() {
        super.onResume()
        println("RegisterFragment.onResume")
    }

    override fun onStart() {
        super.onStart()
        println("RegisterFragment.onStart")
    }
    override fun onDestroy() {
        super.onDestroy()
        println("RegisterFragment.onDestroy")
    }

}