@file:Suppress("DEPRECATION")
package com.example.demomoyel.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.demomoyel.R
import com.example.demomoyel.databinding.FragmentSplashBinding
import com.example.demomoyel.ui.AppFragment
import java.util.concurrent.Executor

class SplashFragment : AppFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    override fun initComponent(view: View, savedInstanceState: Bundle?) {
        Handler().postDelayed({
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
        },1000)
    }
}