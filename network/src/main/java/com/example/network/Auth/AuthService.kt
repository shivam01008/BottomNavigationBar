package com.example.network.Auth

import com.example.network.model.NetworkModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/doctor/doctor-login")
    suspend fun login(@Body hashMap: HashMap<String, Any>): Response<NetworkModel>
}