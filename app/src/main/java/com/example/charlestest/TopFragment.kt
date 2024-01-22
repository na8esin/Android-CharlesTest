package com.example.charlestest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TopFragment : Fragment() {

    companion object {
        fun newInstance() = TopFragment()
    }

    private val viewModel: TopViewModel by viewModels {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        TopViewModelFactory(retrofit)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel // とりあえず、initを呼び出す
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

}