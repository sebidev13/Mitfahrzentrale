package com.example.myapplication

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HelperClass {
    object ApiHelper {
        fun <T> getApiResponse(apiCall: Call<T>,
                               onSuccess: (T) -> Unit,
                               onFailure: (Throwable) -> Unit) {

            apiCall.enqueue(object : Callback<T> {

                override fun onResponse(call: Call<T>,
                                        response: Response<T>) {

                    if (response.isSuccessful) {
                        response.body()?.let { onSuccess(it) }
                    } else {
                        //TODO: Fehler behandeln
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    onFailure(t)
                }
            })
        }
    }

    object StringHelper{
        fun Context.checkStringAndShowToast(string: String?, stringName: String, validAction: (String) -> Unit) {
            when {
                string == null -> {
                    Toast.makeText(this, "$stringName ist null", Toast.LENGTH_SHORT).show()
                }
                string.isEmpty() -> {
                    Toast.makeText(this, "$stringName ist leer", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    validAction(string)
                }
            }
        }
    }
}