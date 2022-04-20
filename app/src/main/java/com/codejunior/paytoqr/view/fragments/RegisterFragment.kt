package com.codejunior.paytoqr.view.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.codejunior.paytoqr.R
import com.codejunior.paytoqr.base.BaseViewModel
import com.codejunior.paytoqr.databinding.RegisterFragmentBinding
import com.codejunior.paytoqr.utils.Utilities.Companion.alertDialogSimple
import com.codejunior.paytoqr.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {

    companion object {
        fun newInstanceRegister() = RegisterFragment()

    }



    private val viewModel: RegisterViewModel by activityViewModels()
    private var _binding:RegisterFragmentBinding? = null
    private val binding  get() = _binding!!

    private  var positiveButtonClick = { dialog: DialogInterface, _: Int ->
        viewModel.navegation.value = BaseViewModel.NAVIGATION.NAV_LOGIN
        dialog.cancel()
        dialog.dismiss()

    }

    private val  negativeButtonClick = { dialog: DialogInterface, _: Int ->
        dialog.cancel()
        dialog.dismiss()

    }


    init {
//        viewModel.navegation.value = BaseViewModel.NAVIGATION.NAV_EMPTY
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("RegisterFragment.onCreate")
       requireActivity().onBackPressedDispatcher.addCallback(this) {
           if(binding.emailRegister.text!!.isNotEmpty()|| binding.passwordRegister.text!!.isNotEmpty()|| binding.rePasswordRegister.text!!.isNotEmpty()){
               binding.registerViewModel!!.utils.value = BaseViewModel.UTILS.DIALOG_PRE_DESIGN
           }else{
            binding.registerViewModel!!.navegation.value = BaseViewModel.NAVIGATION.NAV_LOGIN
           }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater,R.layout.register_fragment,container,false)
        binding.registerViewModel = viewModel
        binding.lifecycleOwner= viewLifecycleOwner
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
    viewModel.navegation.value = BaseViewModel.NAVIGATION.NAV_EMPTY
    viewModel.error.observe(viewLifecycleOwner, {
        when (it) {
            BaseViewModel.ERROR.EMPTY_FIELD -> Toast.makeText(
                context,
                "Field Empty",
                Toast.LENGTH_LONG
            ).show()
        }
    })
    viewModel.navegation.observe(viewLifecycleOwner, {
        when (it) {
            BaseViewModel.NAVIGATION.NAV_LOGIN -> {
                Navigation.findNavController(requireView()).popBackStack()
            }
            else -> {}
        }
    })

    viewModel.utils.observe(viewLifecycleOwner, {
        when (it) {
            BaseViewModel.UTILS.DIALOG_PRE_DESIGN -> {
                alertDialogSimple(context!!,positiveButtonClick,negativeButtonClick)
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
        _binding = null
        viewModel.clear()
        println("RegisterFragment.onDestroy")
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }



   /* private fun alertDialogSimple(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Regresar a login")
        builder.setMessage("¡UPS! tienes informacion en la vista, deseas regresar de igual manera?")
        builder.setPositiveButton("SI", DialogInterface.OnClickListener(function = positiveButtonClick))
        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener(function = negativeButtonClick))
        builder.setCancelable(false)
        builder.show()

    }*/
}