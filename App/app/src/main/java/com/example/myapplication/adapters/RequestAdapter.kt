package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.REST.Request
import com.example.myapplication.REST.Route
import com.example.myapplication.models.RequestMsg

class RequestAdapter(
    val context: Context,
    val requestMsg: MutableList<Request>
): BaseAdapter() {
    override fun getCount(): Int {
        return requestMsg.size
    }

    override fun getItem(position: Int): Any {
        return requestMsg[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context. getSystemService (
            Context. LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View

        if (convertView == null){
            view = inflater.inflate(
                R.layout.request_list_item,
                parent ,
                false)
        }else {
            view = convertView
        }

        val item = getItem(position) as RequestMsg

        val startPoint: TextView = view.findViewById(R.id.startPoint)
        val destinationPoint: TextView = view.findViewById(R.id.destinationPoint)
        val driveRequestBtn: ImageView = view.findViewById(R.id.acceptBtn)

        val startTime: TextView = view.findViewById(R.id.startTime)
        val destinationTime: TextView = view.findViewById(R.id.destinationTime)
        val saveRouteBtn: ImageView = view.findViewById(R.id.declineBtn)

        val passenger: TextView = view.findViewById(R.id.passenger)

        item?.let {
            startPoint.text = item.start_point
            destinationPoint.text = item.destination
            startTime.text = item.start_time
            destinationTime.text = item.destination_time
            passenger.text = item.passenger
        }
        return view
    }
}