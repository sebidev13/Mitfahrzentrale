package com.example.myapplication

import com.example.myapplication.REST.User

object Constants{
    const val REGISTRATION_URI = "https://www.google.com"
    const val BASE_URL = "http://172.19.73.2:8080/"

    const val API_EP = "/api"
    const val ROUTE_EP = "/route"
    const val USER_EP = "/user"
    const val REQUEST_EP = "/request"

    const val SAVED_ROUTE_EP = "/saved"
    const val CREATED_ROUTE_EP = "/created"
    const val ACCEPTED_ROUTE_EP = "/accepted"

    var CURRENT_USER : User ? = null
}