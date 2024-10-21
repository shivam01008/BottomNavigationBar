package com.example.network.Auth

import com.example.network.model.NetworkModel
import retrofit2.Response

interface Auth {
    suspend fun login(email: String, password: String, deviceToken: String): Response<NetworkModel>
}