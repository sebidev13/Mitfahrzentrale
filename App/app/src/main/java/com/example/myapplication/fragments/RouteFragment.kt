package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.NewRouteAdapter
import com.example.myapplication.adapters.RouteAdapter
import com.example.myapplication.models.Supplier

class RouteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.fragment_route)

        //val listView : ListView = findViewById(R.id.listView)

        //val routes = Supplier.routes

        //var routeAdapter = NewRouteAdapter ( this, routes)
        //listView.adapter = routeAdapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_route, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView : ListView = view.findViewById(R.id.listView)

        val routes = Supplier.routes

        var routeAdapter = NewRouteAdapter(requireContext(), routes)
        listView.adapter = routeAdapter
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