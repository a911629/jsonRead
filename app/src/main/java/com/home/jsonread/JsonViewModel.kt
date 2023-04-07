package com.home.jsonread

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.google.gson.Gson
import com.google.gson.JsonObject

class JsonViewModel : ViewModel() {
    val text: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun load() {
        viewModelScope.launch {
            val jsonObject = Gson().fromJson(loadData(), JsonObject::class.java)
            text.value = "你的IP位址: ${jsonObject.get("ip").asString}"
//            text.value = "你的IP位址:"
        }
    }

    private suspend fun loadData(): String {
        val url = "http://ip.jsontest.com/"
        var jsonIn = ""
        try {
            jsonIn = JsonRead().jsonGet(url)
        } catch (e: Exception) {
            Log.d("calvin", "loadData: load failed")
        }
        return jsonIn
    }
}