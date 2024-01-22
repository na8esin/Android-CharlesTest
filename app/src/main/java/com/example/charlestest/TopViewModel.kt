package com.example.charlestest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class TopViewModel(retrofit: Retrofit) : ViewModel() {
    init {
        viewModelScope.launch {
            try {
                val product = retrofit.create(ProductService::class.java).first()
                Log.d("TopViewModel", product.toString())
            } catch (e: Exception) {
                Log.e("TopViewModel", e.toString())
            }
        }
    }
}

class TopViewModelFactory(private val retrofit: Retrofit) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TopViewModel(retrofit) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}