package com.example.network.Auth

import com.example.network.model.NetworkModel
import retrofit2.Response

class AuthImpl(private val auth: AuthService) : Auth {


    override suspend fun login(
        email: String,
        password: String,
        deviceToken: String
    ): Response<NetworkModel> {
        val hashMap = hashMapOf<String, Any>()
        hashMap["email"] = email
        hashMap["password"] = password
        hashMap["device_token"] = deviceToken
        hashMap["device_type"] = "android"
        return auth.login(hashMap)
    }
}