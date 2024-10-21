package com.example.urheath.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

open class BaseViewModel : ViewModel() {

    val error = MutableLiveData<String>()

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.d("CoroutineExceptionHandler", throwable.message ?: "")
            error.postValue(throwable.message ?: "")
        }

    fun io(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(coroutineExceptionHandler) {
            block.invoke(this)
        }
    }
    suspend fun <T> api(apiCall: suspend () -> Response<T>): NetworkResponse<T> {
        return try {
            val response = apiCall.invoke()
            if (response.isSuccessful) NetworkResponse.Success(response.body())
            else NetworkResponse.Failure(getError(response))
        } catch (e: IOException) {
            Log.d("API_CALL", "IO Exception apiCall: ${e.message}")
            NetworkResponse.Failure(Throwable("Network error: ${e.message}"))
        } catch (e: Exception) {
            Log.d("API_CALL", "${e::class.java.simpleName} exception apiCall: ${e.message}")
            NetworkResponse.Failure(Throwable("Unknown error: ${e.message}"))
        }
    }

    private fun <T> getError(response: Response<T>): Throwable {
        val errorModel = response.errorBody()?.let {
            Gson().fromJson(it.string(), ErrorModel::class.java)
        }
        return if (errorModel != null) Throwable(errorModel.message) else Throwable(
            "Unknown error"
        )
    }
}
data class ErrorModel(
    val message: String,
    val success: Boolean
)

sealed class NetworkResponse<out T> {
    data class Success<out T>(val value: T?) : NetworkResponse<T>()
    data class Failure(val throwable: Throwable?) : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
    object Empty : NetworkResponse<Nothing>()
}
