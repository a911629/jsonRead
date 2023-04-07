package com.home.jsonread


import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class JsonRead {
    suspend fun  jsonGet(url: String): String {
        var jsonIn = ""
        withContext(Dispatchers.IO) {
            (URL(url).openConnection() as? HttpURLConnection)?.run {
                if (responseCode == 200) {
                    inputStream.bufferedReader().useLines { lines ->
                        jsonIn = lines.fold("") { text, line -> "$text$line" }
                        Log.d("calvin", "input: $jsonIn")
                    }
                }
            }
        }
        return jsonIn
    }
}