package com.codejunior.paytoqr.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.codejunior.paytoqr.R
import com.codejunior.paytoqr.base.BaseViewModel
import com.codejunior.paytoqr.databinding.RegisterFragmentBinding
import com.codejunior.paytoqr.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {

    companion object {
        fun newInstanceRegister() = RegisterFragment()

    }



    private val viewModel: RegisterViewModel by activityViewModels()
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
        binding.registerViewModel = viewModel
        binding.lifecycleOwner= this
        println("RegisterFragment.onCreateView")
        return binding.root
    }

/*    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        println("RegisterFragment.onActivityCreated")
        // TODO: Use the ViewModel


    }*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.error.observe(this,{
            when(it){
                BaseViewModel.ERROR.EMPTY_FIELD -> Toast.makeText(context,"Field Empty",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.navegation.observe(this,{
            when(it){
                BaseViewModel.NAVIGATION.NAV_LOGIN -> {
                    val nanController: NavController = Navigation.findNavController(requireView())
                    nanController.navigate(R.id.action_registerFragment_to_loginFragment)
                }
            }
        })

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