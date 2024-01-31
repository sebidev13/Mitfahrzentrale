package com.example.myapplication.REST

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import com.example.myapplication.Constants
import com.example.myapplication.Constants.ACCEPTED_ROUTE_EP
import com.example.myapplication.Constants.API_EP
import com.example.myapplication.Constants.CREATED_ROUTE_EP
import com.example.myapplication.Constants.REQUEST_EP
import com.example.myapplication.Constants.ROUTE_EP
import com.example.myapplication.Constants.SAVED_ROUTE_EP
import com.example.myapplication.Constants.USER_EP
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PUT

interface ApiService {

    //Route
    @POST(API_EP + ROUTE_EP)
    fun createRoute(@Body route: Route): Call<Route>

    @DELETE(API_EP + ROUTE_EP + "/{id}")
    fun deleteRoute(@Path("id") id: Int): Call<Route>

    @GET(API_EP + ROUTE_EP + CREATED_ROUTE_EP + "/{driver_id}")
    fun getCreatedRoutes(@Path("driver_id") driver_id: Int): Call<Route>

    @GET(API_EP + ROUTE_EP + SAVED_ROUTE_EP + "/{user_id}")
    fun getSavedRoutes(@Path("user_id") user_id: Int): Call<Route>

    //TODO: createSavedRoutes
    //TODO: deleteSavedRoutes

    @GET(API_EP + ROUTE_EP + ACCEPTED_ROUTE_EP + "/{passenger_id}")
    fun getPassengerRoutes(@Path("passenger_id") passenger_id: Int): Call<Route>

    //TODO: Bei delete route_id richtig ?
    @DELETE(API_EP + ROUTE_EP + ACCEPTED_ROUTE_EP + "/{route_id}")
    fun deletePassengerRoute(@Path("route_id") route_id: Int) : Call<Route>


    //USER
    @GET(API_EP + USER_EP + "/{username}")
    fun getUserByName(@Path("username") username: String) : Call<User>

    @GET(API_EP + USER_EP + "/{email}")
    fun getUserByEmail(@Path("email") email: String) : Call<User>

    @POST(API_EP + USER_EP)
    fun createUser(@Body user: User): Call<User>

    @DELETE(API_EP + USER_EP + "/{user_id}")
    fun deleteUser(@Path("user_id") user_id: Int) : Call<User>

    //REQUEST
    @GET(API_EP + REQUEST_EP + "/{driver_id}")
    fun getRequest4Driver(@Path("driver_id") driver_id: Int) : Call<Request>

    @GET(API_EP + REQUEST_EP + "/{passenger_id}")
    fun getRequest4Passenger(@Path("passenger_id") passenger_id: Int) : Call<Request>

    @PUT(API_EP + REQUEST_EP + "/{request_id}")
    fun putRequest(@Path("request_id") request_id: Int): Call<Request>

    @POST(API_EP + REQUEST_EP)
    fun createRequest(@Body request: Request): Call<Request>

}