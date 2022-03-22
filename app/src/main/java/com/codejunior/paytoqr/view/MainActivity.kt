package com.codejunior.paytoqr.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.codejunior.paytoqr.R
import com.codejunior.paytoqr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding:ActivityMainBinding? = null
    private val binding  get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        println("MainActivity.onCreate")
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onPause() {
        super.onPause()
        println("MainActivity.onPause")
    }

    override fun onStop() {
        super.onStop()
        println("MainActivity.onStop")
    }

    override fun onResume() {
        super.onResume()
        println("MainActivity.onResume")
    }

    override fun onStart() {
        super.onStart()
        println("MainActivity.onStart")
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}