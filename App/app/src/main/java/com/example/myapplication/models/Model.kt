package com.example.myapplication.models

import java.sql.Time

data class Route(
    var start_point: String,
    var destination: String,
    var start_time: String,
    var destination_time: String,
    var driver: String,
    var cities: Array<String>?)

data class MyRides(
    var start_point: String,
    var destination: String,
    var start_time: String,
    var destination_time: String,
    var driver: String,
    var cities: Array<String>?)
data class RequestMsg(
    var start_point: String,
    var destination: String,
    var start_time: String,
    var destination_time: String,
    var passenger: String)
object Supplier {
    val requestMsg = listOf<RequestMsg>(
        RequestMsg(
            "Bischofswiesen",
            "Traunstein",
            "23.01.2023 8:00",
            "23.01.2023 9:00",
            "tos",
        ),
        RequestMsg(
            "Bischofswiesen",
            "Traunstein",
            "23.01.2023 8:00",
            "23.01.2023 9:00",
            "tos",
        )
    )
    val routes = listOf<Route>(
        Route(
            "Bischofswiesen",
            "Traunstein",
             "23.01.2023 8:00",
            "23.01.2023 9:00",
            "tos",
            null
        ),
        Route(
            "Traunstein",
            "Bischofswiesen",
            "23.01.2023 12:00",
            "23.01.2023 13:00",
            "sv",
            null
        ),
        Route(
            "Bischofswiesen",
            "Traunstein",
            "23.01.2023 8:00",
            "23.01.2023 9:00",
            "sv",
            null
        ),
        Route(
            "Traunstein",
            "Bischofswiesen",
            "23.01.2023 12:00",
            "23.01.2023 13:00",
            "tos",
            null
        )
    )
    val myRides = listOf<MyRides>(
        MyRides(
            "Bischofswiesen",
            "Traunstein",
            "23.01.2023 8:00",
            "23.01.2023 9:00",
            "tos",
            null
        ),
        MyRides(
            "Bischofswiesen",
            "Traunstein",
            "23.01.2023 8:00",
            "23.01.2023 9:00",
            "tos",
            null
        )
    )
}