package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.RequestAdapter
import com.example.myapplication.adapters.SavedAdapter
//import com.example.myapplication.adapters.RouteAdapter
import com.example.myapplication.models.Supplier

class SavedFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_saved,
            container,
            false)

        // Set up the RecyclerView
        //setupRecyclerView(view)

        //return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView : ListView = view.findViewById(R.id.listView)

        val requests = Supplier.routes

        var requestAdapter = SavedAdapter(requireContext(), requests)
        listView.adapter = requestAdapter
    }

    /* private fun setupRecyclerView(viewx: View) {


         val layoutManager = LinearLayoutManager(requireContext())
         layoutManager.orientation = LinearLayoutManager.VERTICAL

         val adapter = SavedAdapter(requireContext(), Supplier.routes)

         var recycView: RecyclerView? = viewx.findViewById(R.id.savedRecyView)
         recycView?.let {
             recycView.adapter = adapter
             recycView.layoutManager = layoutManager
        }*/
}