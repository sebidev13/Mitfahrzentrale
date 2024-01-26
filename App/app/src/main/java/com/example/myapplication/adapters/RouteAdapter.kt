package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Route

class RouteAdapter (val context: Context, private val routes: List<Route>) : RecyclerView.Adapter<RouteAdapter.RouteViewHolder>(){

    inner class RouteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentRoute: Route? = null
        var currentPosition: Int = 0

        val startPoint: TextView = itemView.findViewById(R.id.startPoint)
        val destinationPoint: TextView = itemView.findViewById(R.id.destinationPoint)
        val driveRequestBtn: ImageView = itemView.findViewById(R.id.driveRequestBtn)

        val startTime: TextView = itemView.findViewById(R.id.startTime)
        val destinationTime: TextView = itemView.findViewById(R.id.destinationTime)
        val saveRouteBtn: ImageView = itemView.findViewById(R.id.saveRouteBtn)

        val driver: TextView = itemView.findViewById(R.id.driverTV)

        init {

            driveRequestBtn.setOnClickListener {
                //TODO: Anfrage zur mitfahrt senden
            }

            saveRouteBtn.setOnClickListener {
                //TODO: Route speichern
            }
        }

        fun setData(route: Route?, position: Int){

            route?.let {
                startPoint.text = route.start_point
                destinationPoint.text = route.destination
                startTime.text = route.start_time
                destinationTime.text = route.destination_time
                driver.text = route.driver
            }
            this.currentRoute = route
            this.currentPosition = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.route_list_item, parent, false)
        return RouteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return routes.size
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        val route = routes[position]
        holder.setData(route, position)
    }

}