package com.example.demomoyel.ui.login

import androidx.appcompat.widget.VectorEnabledTintResources
import com.google.android.material.tabs.TabLayout

interface ILoginContract {
    interface View {
        fun userError(error: String)
        fun passwordError(error: String)
        fun enableLoginButton(enable: Boolean)
        fun showLoading(isVisible: Int)
        fun showMessage(msg: String)
        fun launchMenu()
    }
    interface Presenter {
        fun onInit(view: View, model: Model)
        fun onLogin(user: String, password: String)
    }

    interface Model {
        fun onRequestLogin(user: String,password: String): Boolean
    }
}

// M - Model - Repository, Use Cases, Database, Preferences
// V - View - Views, onclick, adapter...
// P - Presenter - Interactuar entre View y el model (ejecuto fun modelo y paso el resultado a la vista)