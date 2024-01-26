package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.adapters.MyRidesAdapter
import com.example.myapplication.adapters.NewRouteAdapter
import com.example.myapplication.models.Supplier

class DriverFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_driver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView : ListView = view.findViewById(R.id.listView)

        val myrides = Supplier.myRides

        var ridesAdapter = MyRidesAdapter(requireContext(), myrides)
        listView.adapter = ridesAdapter
    }


}