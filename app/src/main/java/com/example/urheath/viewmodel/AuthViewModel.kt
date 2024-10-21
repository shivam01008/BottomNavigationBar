package com.example.urheath.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.network.Auth.Auth
import com.example.network.model.NetworkModel
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(private val auth: Auth) : BaseViewModel() {

    private val _loginResponse = MutableStateFlow<NetworkResponse<NetworkModel>?>(null)

    val loginResponse: StateFlow<NetworkResponse<NetworkModel>?> = _loginResponse

    fun login(email: String, password: String, token: String) {
        io {
            _loginResponse.value = NetworkResponse.Loading
            _loginResponse.value = api {
                auth.login(email, password, token)
            }
        }
    }
}


