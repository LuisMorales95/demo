package com.example.demomoyel.ui.login

class LoginModel : ILoginContract.Model {

    override fun onRequestLogin(user: String, password: String): Boolean {
       return (user.equals("1") && password.equals("1"))
    }
}