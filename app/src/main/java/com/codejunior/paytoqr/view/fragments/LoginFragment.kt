package com.codejunior.paytoqr.view.fragments

import android.content.Context
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
import com.codejunior.paytoqr.databinding.BlankFragmentBinding
import com.codejunior.paytoqr.view.MainMenu
import com.codejunior.paytoqr.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("LoginFragment.onViewCreated")
        binding.crearCuentaLogin.setOnClickListener{
            val nanController: NavController = Navigation.findNavController(requireView())
            nanController.navigate(R.id.action_loginFragment_to_registerFragment)
            /*requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_login, newInstanceRegister()).commit();*/

        }
        binding.inicarCuentaLogin.setOnClickListener {
            val intent = Intent (this.context, MainMenu::class.java)
            startActivity(intent)
        }



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

}