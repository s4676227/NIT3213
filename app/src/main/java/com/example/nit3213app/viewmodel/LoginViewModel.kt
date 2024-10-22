package com.example.nit3213app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nit3213app.model.LoginRequest
import com.example.nit3213app.model.LoginResponse
import com.example.nit3213app.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    private val _loginResponse = MutableLiveData<LoginResponse?>()
    val loginResponse: LiveData<LoginResponse?> get() = _loginResponse

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = apiService.login(LoginRequest(username, password))
            if (response.isSuccessful) {
                _loginResponse.postValue(response.body())
            } else {
                _loginResponse.postValue(null)
            }
        }
    }
}
