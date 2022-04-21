package com.codejunior.paytoqr.view.fragments

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.codejunior.paytoqr.R
import com.codejunior.paytoqr.base.BaseViewModel
import com.codejunior.paytoqr.databinding.BlankFragmentBinding
import com.codejunior.paytoqr.utils.Utilities.Companion.alertDialogSimple
import com.codejunior.paytoqr.view.MainMenu
import com.codejunior.paytoqr.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }
    private  var positiveButtonClick = { dialog: DialogInterface, _: Int ->
        clearView()
        dialog.cancel()
        dialog.dismiss()
        navigateRegister()

    }

    private val  negativeButtonClick = { dialog: DialogInterface, _: Int ->
        dialog.cancel()
        dialog.dismiss()

    }
    private var _binding: BlankFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModelLoginViewModel: LoginViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("LoginFragment.onAttach")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("LoginFragment.onCreate")

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BlankFragmentBinding.inflate(inflater,container,false)
        binding.loginViewModel = viewModelLoginViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("LoginFragment.onViewCreated")

            viewModelLoginViewModel.navegation.value = BaseViewModel.NAVIGATION.NAV_EMPTY
            viewModelLoginViewModel.navegation.observe(viewLifecycleOwner,{
                when(it){
                    BaseViewModel.NAVIGATION.NAV_REGISTER -> {
                        if(binding.emailLogin.text!!.isNotEmpty()|| binding.password.text!!.isNotEmpty()){
                            viewModelLoginViewModel.utils.value = BaseViewModel.UTILS.DIALOG_PRE_DESIGN
                        }else{
                            navigateRegister()
                        }
                    }
                    BaseViewModel.NAVIGATION.NAV_MENU -> {
                        val intent = Intent(this.context, MainMenu::class.java)
                        startActivity(intent)
                    }

                    else -> {}
                }
            })

        viewModelLoginViewModel.utils.observe(viewLifecycleOwner,{

            when(it){
                BaseViewModel.UTILS.DIALOG_PRE_DESIGN -> alertDialogSimple(context!!,positiveButtonClick,negativeButtonClick)
            }

        })

            /*requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_login, newInstanceRegister()).commit();*/

    }

    private fun navigateRegister() {
        val nanController: NavController = Navigation.findNavController(requireView())
        nanController.navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private  fun clearView(){
        binding.emailLogin.text = null
        binding.password.text = null
    }


    override fun onPause() {
        super.onPause()
        println("LoginFragment.onPause")
    }

    override fun onStop() {
        super.onStop()
        println("LoginFragment.onStop")
    }

    override fun onResume() {
        super.onResume()
        println("LoginFragment.onResume")
    }

    override fun onStart() {
        super.onStart()
        println("LoginFragment.onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("LoginFragment.onDestroy")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}