package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.models.MyRides

class MyRidesAdapter(
    val context: Context,
    val myRides: List<MyRides>): BaseAdapter() {
    override fun getCount(): Int {
        return myRides.size
    }

    override fun getItem(position: Int): Any {
        return myRides[position]
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
                R.layout.myrides_list_item,
                parent,
                false)
        }else {
            view = convertView
        }

        val item = getItem(position) as MyRides

        val startPoint: TextView = view.findViewById(R.id.startPoint)
        val destinationPoint: TextView = view.findViewById(R.id.destinationPoint)
        val deleteBtn: ImageView = view.findViewById(R.id.deleteBtn)

        val startTime: TextView = view.findViewById(R.id.startTime)
        val destinationTime: TextView = view.findViewById(R.id.destinationTime)

        item?.let {
            startPoint.text = item.start_point
            destinationPoint.text = item.destination
            startTime.text = item.start_time
            destinationTime.text = item.destination_time
        }
        return view
    }
}