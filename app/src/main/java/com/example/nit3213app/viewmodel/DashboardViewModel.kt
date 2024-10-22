package com.example.nit3213app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nit3213app.model.DashboardResponse
import com.example.nit3213app.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private val _entities = MutableLiveData<List<DashboardResponse.Entity>>()
    val entities: LiveData<List<DashboardResponse.Entity>> get() = _entities

    fun loadEntities(keypass: String) {
        viewModelScope.launch {
            try {
                val response: Response<DashboardResponse> = apiService.getDashboard(keypass)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _entities.postValue(it.entities)
                    }
                } else {
                    _entities.postValue(emptyList())
                }
            } catch (e: Exception) {
                _entities.postValue(emptyList())
            }
        }
    }
}