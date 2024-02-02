package com.example.myapplication.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.myapplication.Constants
import com.example.myapplication.HelperClass
import com.example.myapplication.R
import com.example.myapplication.REST.RetrofitClient
import com.example.myapplication.REST.Route
import com.example.myapplication.activities.MainActivity
import com.example.myapplication.models.MyRides

class DriverRoutesAdapter(
    val context: Context,
    val driverRoutes: MutableList<Route>): BaseAdapter() {
    override fun getCount(): Int {
        return driverRoutes.size
    }
    override fun getItem(position: Int): Any {
        return driverRoutes[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater = context. getSystemService (Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View

        if (convertView == null){
            view = inflater.inflate(R.layout.myrides_list_item, parent,false)
        }else {
            view = convertView
        }

        val item = getItem(position) as Route//MyRides

        val startPoint: TextView = view.findViewById(R.id.startPoint)
        val destinationPoint: TextView = view.findViewById(R.id.destinationPoint)
        val deleteBtn: ImageView = view.findViewById(R.id.deleteBtn)

        deleteBtn.setOnClickListener{
            val call = RetrofitClient.apiService.deleteRoute(item.id)

            HelperClass.ApiHelper.getApiResponse(call,
                onSuccess = { response ->
                    driverRoutes.removeAt(position)
                    notifyDataSetChanged()
                },
                onFailure = { t ->
                    Toast.makeText(context, t.localizedMessage, Toast.LENGTH_LONG ).show()
                }
            )
        }

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