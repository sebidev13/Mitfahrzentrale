package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.RouteAdapter
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
        val view = inflater.inflate(R.layout.fragment_saved, container, false)

        // Set up the RecyclerView
        setupRecyclerView(view)

        return view
    }

    private fun setupRecyclerView(viewx: View) {

        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        val adapter = RouteAdapter(requireContext(), Supplier.routes)

        var recycView: RecyclerView? = viewx.findViewById(R.id.savedRecyView)
        recycView?.let {
            recycView.adapter = adapter
            recycView.layoutManager = layoutManager
        }
    }


}