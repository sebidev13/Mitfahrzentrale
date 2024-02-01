package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.Constants
import com.example.myapplication.HelperClass
import com.example.myapplication.R
import com.example.myapplication.REST.RetrofitClient
import com.example.myapplication.adapters.PassengerRouteAdapter
import com.example.myapplication.adapters.RequestAdapter

class RouteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_route, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var routes : MutableList<com.example.myapplication.REST.Route> = mutableListOf()
        val routeListView : ListView = view.findViewById(R.id.listView)
        var routeAdapter : PassengerRouteAdapter

        val requestCall = RetrofitClient.apiService.getAllRoutes()

        HelperClass.ApiHelper.getApiResponse(requestCall,
            onSuccess = { response ->
                routes = response.toMutableList()
                routeAdapter = PassengerRouteAdapter(requireContext(), routes)
                routeListView.adapter = routeAdapter
            },
            onFailure = { t ->
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_LONG ).show()
            }
        )


        //val routes = Supplier.routes

        //var routeAdapter = NewRouteAdapter(requireContext(), routes)
        //listView.adapter = routeAdapter
    }

   /* override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_route, container, false)

        // Set up the RecyclerView
        //setupRecyclerView(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /* private fun setupRecyclerView(viewx: View) {

        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        val adapter = RouteAdapter(requireContext(), Supplier.routes)

        var recycView: RecyclerView? = viewx.findViewById(R.id.routeRecyView)
        recycView?.let {
            recycView.adapter = adapter
            recycView.layoutManager = layoutManager
        }
    } */ */
}