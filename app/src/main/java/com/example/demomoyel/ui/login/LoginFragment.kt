package com.example.demomoyel.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.demomoyel.R
import com.example.demomoyel.databinding.FragmentLoginBinding
import com.example.demomoyel.ui.AppFragment

class LoginFragment : AppFragment<FragmentLoginBinding> (R.layout.fragment_login), ILoginContract.View {

    lateinit var loginPresenter: ILoginContract.Presenter

    override fun initComponent(view: View, savedInstanceState: Bundle?) {
        loginPresenter = LoginPresenter()
        loginPresenter.onInit(this, LoginModel())

        binding.loginButton.setOnClickListener {
            loginPresenter.onLogin(binding.userInput.editText?.text.toString(), binding.passwordInput.editText?.text.toString())
        }
    }

    override fun showMessage(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun userError(error: String) {
        binding.userInput.error = error
    }

    override fun passwordError(error: String) {
        binding.passwordInput.error = error
    }

    override fun enableLoginButton(enable: Boolean) {
        binding.loginButton.isEnabled = enable
    }

    override fun showLoading(isVisible: Int) {
        binding.progressBar.visibility = isVisible
    }

    override fun launchMenu() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())
    }
}