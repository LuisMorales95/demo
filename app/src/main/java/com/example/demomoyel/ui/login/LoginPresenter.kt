package com.example.demomoyel.ui.login

import android.view.View

class LoginPresenter : ILoginContract.Presenter{

    lateinit var view: ILoginContract.View
    lateinit var model: ILoginContract.Model

    override fun onInit(view: ILoginContract.View, model: ILoginContract.Model) {
        this.view = view
        this.model = model
    }

    override fun onLogin(user: String, password: String) {
        view.showLoading(View.VISIBLE)
        view.enableLoginButton(false)
        if (user.isNotEmpty() && password.isNotEmpty()){
            view.showLoading(View.GONE)
            view.enableLoginButton(true)

            val logged = model.onRequestLogin(user, password)
            if (logged){
                view.launchMenu()
            } else {
                view.showLoading(View.GONE)
                view.enableLoginButton(true)
                view.showMessage("Credenciales Invalidas")
            }
        } else {
            view.showLoading(View.GONE)
            view.enableLoginButton(true)
            view.userError("Requerido")
            view.passwordError("Requerido")
            view.showMessage("Rellenar ambos campos, porfavor")
        }
    }

}