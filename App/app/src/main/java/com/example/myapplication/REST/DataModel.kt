package com.example.myapplication.REST

data class Route(
    val id: Int,
    var start_point: String,
    var destination: String,
    var start_time: String,
    var destination_time: String,
    val driver_id: Int,
    val crossed_city_ids: String
)

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val password: String,
    val last_name: String,
    val first_name: String,
    val phone: String,
    val address_id: Address ?
)

data class Address(
    val id: Int,
    val street: String,
    val city: String,
    val zip_code: String,
    val geo_code: String
)

data class Request(
    val driver_user_id: User,
    val passenger_id: User,
    val route_id: Route,
    val is_accepted: Boolean
)

data class Waypoint(
    val route_id: Route,
    val user_id: User,
    val arriving: String
)

data class SavedUserRoute(
    val route_id: Route,
    val user_id: User
)